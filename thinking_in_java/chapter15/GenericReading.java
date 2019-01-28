package thinking_in_java.chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangbin10 on 2019/1/28.
 */
public class GenericReading {
    /**
     * 精确类型
     * @param list
     * @param <T>
     * @return
     */
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    static void f1() {
        Apple apple = readExact(apples);
        Fruit fruit = readExact(fruits);
        fruit = readExact(apples);
    }

    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    /**
     * 虽然合情合理，reader.readExact(apples);却不能编译通过，因为它只接受Fruit类型的参数
     */
    static void f2() {
        Reader<Fruit> reader = new Reader<Fruit>();
        Fruit fruit = reader.readExact(fruits);
//    reader.readExact(apples);
    }

    /**
     * readCovariant接受T或T的子类型作为参数
     * @param <T>
     */
    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> fruitCovariantReader = new CovariantReader<>();
        fruitCovariantReader.readCovariant(fruits);
        fruitCovariantReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();

    }

}
