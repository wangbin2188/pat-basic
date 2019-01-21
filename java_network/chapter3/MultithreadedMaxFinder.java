package java_network.chapter3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by wangbin10 on 2019/1/21.
 * 多线程方式求数组最大值
 */
public class MultithreadedMaxFinder {
    public static int max(int[] data) throws ExecutionException, InterruptedException {
        if (data.length == 1) {
            return data[0];
        } else if (data.length == 0) {
            throw new IllegalArgumentException();
        }

        FindMaxTask task1 = new FindMaxTask(data, 0, data.length / 2);
        FindMaxTask task2 = new FindMaxTask(data,  data.length / 2,data.length);

        ExecutorService exec = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = exec.submit(task1);
        Future<Integer> future2 = exec.submit(task2);
        return Math.max(future1.get(), future2.get());
    }
}
