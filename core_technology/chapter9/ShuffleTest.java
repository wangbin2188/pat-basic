package chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleTest {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 49; i++) {
            nums.add(i);
        }

        Collections.shuffle(nums);
        List<Integer> integers = nums.subList(0, 6);
        Collections.sort(integers);
        System.out.println(integers);
    }
}
