package thinking_in_java.chapter21;

/**
 * Created by wangbin10 on 2019/1/11.
 */
public class Joining {
    public static void main(String[] args) {
        Sleeper s1 = new Sleeper("s1", 1500);
        Sleeper s2 = new Sleeper("s2", 1500);
        Joiner j1 = new Joiner("j1", s1);
        Joiner j2 = new Joiner("j2", s2);
//        s2.interrupt();
    }
}

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName()+" has awake");
    }
}

class Joiner extends Thread {
private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName()+" join completed");
    }
}