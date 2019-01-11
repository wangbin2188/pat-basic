package thinking_in_java.chapter21;

/**
 * Created by wangbin10 on 2019/1/11.
 */
public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread t = new Thread(this);

    public SelfManaged() {
        t.start();
    }

    public String toString() {
        return Thread.currentThread().getName() +
                "(" + countDown + "), ";
    }

    public void run() {
        while (true) {
            System.out.print(this);
            if (--countDown == 0)
                return;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            new SelfManaged();
    }
}
