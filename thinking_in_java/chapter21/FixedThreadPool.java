package thinking_in_java.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangbin10 on 2019/1/9.
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
