package thinking_in_java.chapter17;

import thinking_in_java.chapter16.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by wangbin10 on 2019/1/29.
 */
public class CollectionDataGeneration {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(CollectionData.list(new RandomGenerator.String(4), 8));
        System.out.println(strings);
        CollectionData<Integer> list = CollectionData.list(new RandomGenerator.Integer(), 7);
        System.out.println(list);
        HashSet<Integer> integers = new HashSet<>(list);
        System.out.println(integers);

    }
}
