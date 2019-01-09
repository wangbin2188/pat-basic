package thinking_in_java.chapter21;

/**
 * Created by wangbin10 on 2019/1/9.
 */
public class LiftOff implements Runnable {
    protected int countDown=10;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return Thread.currentThread().getName()+"("+countDown+") ";
    }

    @Override
    public void run() {
        while (countDown > 0) {
            System.out.print(status());
            Thread.yield();
            countDown--;
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("wait for liftoff");

    }
}
