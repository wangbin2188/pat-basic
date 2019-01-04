package core_technology.chapter14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by wangbin10 on 2019/1/4.
 */
public class MatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatchCounter(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    /**
     * 如果目录下有多个文件夹，则对每个文件夹都创建一个Callable对象，在线程池中提交,这是一种递归方法
     * 如果是文件，则在文件中搜索关键字，命中则count++
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        count = 0;
        File[] files = directory.listFiles();
        ArrayList<Future<Integer>> results = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                MatchCounter matchCounter = new MatchCounter(file, keyword, pool);
                Future<Integer> result = pool.submit(matchCounter);
                results.add(result);
            } else {
                if (search(file)) {
                    count++;
                }
            }
        }

        for (Future<Integer> result : results) {
            count+= result.get();
        }
        return count;
    }

    /**
     * 在文件中查找关键词,只要找到则停止向下查找
     * @param file
     * @return
     */
    private boolean search(File file) {
        try (Scanner scanner = new Scanner(file)) {
            boolean found = false;
            while (!found && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(keyword)) {
                    found = true;
                }
            }
            return found;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }
}
