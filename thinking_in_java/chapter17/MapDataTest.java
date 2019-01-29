package thinking_in_java.chapter17;

import thinking_in_java.chapter15.Generator;
import thinking_in_java.chapter16.CountingGenerator;
import thinking_in_java.chapter16.RandomGenerator;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by wangbin10 on 2019/1/29.
 */
public class MapDataTest {
    public static void main(String[] args) {
        CountingGenerator.Integer integer = new CountingGenerator.Integer();
        CountingGenerator.String string = new CountingGenerator.String(4);
        MapData<Integer, String> map = MapData.map(integer, string, 7);
        System.out.println(map);

        HashMap<Integer, String> newMap = new HashMap<>(map);
        System.out.println(newMap);

        MapData<Integer, String> map1 = MapData.map(new Letters(), 11);
        System.out.println(map1);

        MapData<Integer, Character> map2 = MapData.map(new Letters(), new RandomGenerator.Character());
        System.out.println(map2);
    }
}

class Letters implements Generator<Pair<Integer, String>>,Iterable<Integer> {
    private int size=9;
    private int num=1;
    private char letter = 'A';
    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(num++,""+letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return num<size;
            }

            @Override
            public Integer next() {
                return num++;
            }
        };
    }
}
