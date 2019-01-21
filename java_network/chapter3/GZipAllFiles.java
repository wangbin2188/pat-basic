package java_network.chapter3;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangbin10 on 2019/1/21.
 * 固定大小线程池，最大线程数=4
 * 对于main方法传进来的所有文件进行压缩
 */
public class GZipAllFiles {
    public static final int THREAD_COUNT = 4;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
        for (String filename:args) {
            File file = new File(filename);
            if (file.exists()) {
                GzipFile(file, pool);
            }
        }
        /**
         * shutdown不会马上关闭线程池，只是通知线程池不会再有新任务加进来
         */
        pool.shutdown();
    }

    /**
     * 递归处理文件和文件夹
     * @param file
     * @param pool
     */
    private static void GzipFile(File file, ExecutorService pool) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
               GzipFile(files[i],pool);
            }
        } else {
            GZipRunnable task = new GZipRunnable(file);
            pool.submit(task);
        }
    }
}
