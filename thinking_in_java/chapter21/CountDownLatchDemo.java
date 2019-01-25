package thinking_in_java.chapter21;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangbin10 on 2019/1/25.
 * WaitingTask必须等TaskPortion执行完才能执行
 * CountDownLatch用于同步一个或多个任务，强制他们等待由其他任务执行的操作完成
 * CountDownLatch的典型用法是：
 * 1.将一个程序分为N个互相独立的可解决任务，并创建值为0的CountDownLatch;
 * 2.每个子任务完成时都会在锁存器上调用countDown();
 * 3.等待问题被解决的任务在这个锁存器上调用await(),将自己拦住，直至锁存器计数结束（计数为0）。
 */
public class CountDownLatchDemo {
    public static final int SIZE=100;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i <10; i++) {
            exec.submit(new WaitingTask(latch));
        }
        for (int i = 0; i < SIZE; i++) {
            exec.submit(new TaskPortion(latch));
        }

        exec.shutdown();
    }
}

class TaskPortion implements Runnable {
    private static int counter=0;
    private final int id=counter++;
    private static Random random = new Random(47);
    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
        System.out.println(this+"completed");
    }
    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "TaskPortion{" +
                "id=" + id +
                '}';
    }
}

class WaitingTask implements Runnable {
    private static int counter=0;
    private final int id=counter++;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            //调用await任务阻塞
            latch.await();
            System.out.println("latch barrier passed for "+this);
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }

    @Override
    public String toString() {
        return "WaitingTask{" +
                "id=" + id +
                '}';
    }
}
