package java_network.chapter3;

import java.util.concurrent.Callable;

/**
 * Created by wangbin10 on 2019/1/21.
 * Callable就是可以返回结果的Runnable
 * 向ExecutorService提交Callable任务，返回的结果在Future中，如果任务结果未返回，就会阻塞
 */
public class FindMaxTask implements Callable<Integer> {
    private int[] data;
    private int start;
    private int end;

    public FindMaxTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int max=Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }
}
