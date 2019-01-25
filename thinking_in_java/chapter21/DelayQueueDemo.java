package thinking_in_java.chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * Created by wangbin10 on 2019/1/25.
 */
public class DelayQueueDemo {
    public static void main(String[] args) {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue queue = new DelayQueue<DelayedTask>();
        for (int i = 0; i < 20; i++) {
            queue.add(new DelayedTask(rand.nextInt(5000)));
        }
    }
}

class DelayedTask implements Runnable, Delayed {
    private static int counter=0;
    private final int id=counter++;
    private final long trigger;
    protected static List<DelayedTask> sequnce = new ArrayList<>();
    private final int delta;

    public DelayedTask(int delta) {
        this.delta = delta;
        this.trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS);
        sequnce.add(this);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }

    @Override
    public void run() {

    }
}