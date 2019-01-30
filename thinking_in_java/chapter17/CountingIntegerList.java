package thinking_in_java.chapter17;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by wangbin10 on 2019/1/30.
 */
public class CountingIntegerList extends AbstractList<Integer> {
    private int size;

    public CountingIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    @Override
    public Integer get(int index) {
        return Integer.valueOf(index);
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CountingIntegerList integers = new CountingIntegerList(15);
        System.out.println(integers);

    }
}
