package core_technology.chapter14;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by wangbin10 on 2019/1/4.
 * 对大任务的分解递归计算，RecursiveTask
 * fork-join框架使用了一种双端队列来平衡负载，每个线程都对应一个双端队列，从队头取；
 * 如果一个线程空闲，则从另一个队列的队尾取任务
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        final int SIZE=100000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i]=Math.random();
        }
        Counter counter = new Counter(numbers, 0, numbers.length, new Filter() {
            @Override
            public boolean accept(double t) {
                return t > 0.5;
            }
        });
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }
}

interface Filter{
    boolean accept(double t);
}

class Counter extends RecursiveTask<Integer> {
    public static final int THRESHOLD=1000;
    private double [] values;
    private int from;
    private int to;
    private Filter filter;

    public Counter(double[] values, int from, int to, Filter filter) {
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }

    /**
     * 设定了一个阈值THRESHOLD=1000，如果一个任务小于这个值，则对其进行计算；
     * 如果超过了这个值，则进行分解
     * @return
     */
    @Override
    protected Integer compute() {
        if (to - from < THRESHOLD) {
            int count=0;
            for(int i=from;i<to;i++) {
                if (filter.accept(values[i])) {
                    count++;
                }
            }
            return count;
        }else{
            int mid=(to+from)/2;
            Counter first = new Counter(values, from, mid, filter);
            Counter second = new Counter(values, mid , to, filter);
            //invokeAll会对所有任务进行计算，如果个别任务完成，则阻塞，直到所有任务完成，join()方法生成结果
            invokeAll(first, second);
            return first.join()+second.join();
        }
    }
}
