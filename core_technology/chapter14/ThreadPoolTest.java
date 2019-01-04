package core_technology.chapter14;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by wangbin10 on 2019/1/4.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter base directory:");
        String directory = scanner.nextLine();
        System.out.println("enter keyword:");
        String keyword = scanner.nextLine();
        /**
         * 返回一个带缓存的线程池
         * 将任务内容写入counter,由pool.submit()执行
         * result线程执行的返回结果
         * 任务执行完后，调用pool.shutdown()关闭线程池
         */
        ExecutorService pool = Executors.newCachedThreadPool();
        MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
        Future<Integer> result = pool.submit(counter);
        try {
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        pool.shutdown();
        /**
         * 返回线程池的最大线程数
         */
        int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
        System.out.println(largestPoolSize);
    }
}
