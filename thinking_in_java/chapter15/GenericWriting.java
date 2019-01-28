package thinking_in_java.chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangbin10 on 2019/1/28.
 */
public class GenericWriting {
    public static void main(String[] args) {
        f1();
        f2();
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple());
    }

    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    /**
     * list将持有从T导出的某种具体类型
     * @param list
     * @param item
     * @param <T>
     */
    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<Apple>();

    static List<Fruit> fruits = new ArrayList<Fruit>();

    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruits, new Apple());//之前这是不允许的，虽然理论上没有问题
    }

    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruits, new Apple());
    }
}
