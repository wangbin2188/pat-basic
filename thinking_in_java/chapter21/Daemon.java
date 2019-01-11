package thinking_in_java.chapter21;

/**
 * Created by wangbin10 on 2019/1/10.
 */
public class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
        }

        for(int i=0;i<t.length;i++) {
            System.out.println(t[i].isDaemon());
        }

        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}
