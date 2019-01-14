package thinking_in_java.chapter9;

import java.util.Random;

/**
 * Created by wangbin10 on 2019/1/14.
 */
public class RandomDoubles {
    private static Random rand = new Random();

    public double next() {
        return rand.nextDouble();
    }
    public static void main(String[] args) {
        RandomDoubles randomDoubles = new RandomDoubles();
        for (int i = 0; i < 7; i++) {
            System.out.println(randomDoubles.next());
        }
    }
}
