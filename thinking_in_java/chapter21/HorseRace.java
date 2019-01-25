package thinking_in_java.chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by wangbin10 on 2019/1/25.
 * 赛马游戏仿真
 * CyclicBarrier适用于下列情况：
 * 你希望创建一组任务，他们并行的执行，然后在进行下一个步骤之前等待，直至所有任务完成
 * 它使得所有任务都在栅栏处列队，因此可以一致地向前移动
 * 非常像CountDownLatch,只是CountDownLatch只能触发一次事件，CyclicBarrier可以多次重用
 */
public class HorseRace {
    public static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public HorseRace(int nHorses, final int pause) {
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    sb.append("=");
                }
                System.out.println(sb);
                for (Horse horse : horses) {
                    System.out.println(horse.tracks());
                }
                for (Horse horse : horses) {
                    if (horse.getStrides() >= FINISH_LINE) {
                        System.out.println(horse + " won");
                        exec.shutdownNow();
                        return;
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    System.out.println("barrier action sleep interrupted");
                }
            }
        });

        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorses = 7;
        int pause = 200;
        new HorseRace(nHorses, pause);
    }
}

class Horse implements Runnable {
    private int strides = 0;
    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier b) {
        this.barrier = b;
    }

    @Override
    public void run() {
        try {
            while (!(Thread.interrupted())) {
                synchronized (this) {
                    strides += rand.nextInt(3);
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                '}';
    }
}