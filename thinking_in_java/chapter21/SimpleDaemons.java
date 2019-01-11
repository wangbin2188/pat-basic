package thinking_in_java.chapter21;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangbin10 on 2019/1/10.
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName()+this.toString());
            }
        } catch (InterruptedException e) {
            System.out.println("sleep interrupt");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<10;i++) {
            Thread thread = new Thread(new SimpleDaemons());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("all start");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
