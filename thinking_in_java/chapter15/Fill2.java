package thinking_in_java.chapter15;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by wangbin10 on 2019/1/28.
 * Fill2对Collection的要求与Fill不同，它只需要Addable对象
 * 1.AddableCollectionAdapter可以工作于基类型是Collection，任何实现了Collection的都能使用
 * 2.AdapterSimpleQueue适用于基类型不是Collection的类（SimpleQueue），可以通过适配满足要求
 */
public class Fill2 {
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }

    static class AddableCollectionAdapter<T> implements Addable<T> {
        private Collection c;

        public AddableCollectionAdapter(Collection c) {
            this.c = c;
        }

        @Override
        public void add(T t) {
            c.add(t);
        }
    }

    static class Adapter {
        public static <T> Addable<T> collectionAdapter(Collection<T> c) {
            return new AddableCollectionAdapter<T>(c);
        }
    }

    static class AdapterSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
        public void add(T t) {
            super.add(t);
        }
    }

    public static void main(String[] args) {
        ArrayList<Coffee> coffees = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<Coffee>(coffees), Coffee.class, 3);
        Fill2.fill(Adapter.collectionAdapter(coffees), Latte.class, 2);
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }

        System.out.println("=====================");
        AdapterSimpleQueue<Coffee> coffees1 = new AdapterSimpleQueue<>();
        Fill2.fill(coffees1, Mocha.class, 4);
        Fill2.fill(coffees1, Latte.class, 5);
        for (Coffee coffee : coffees1) {
            System.out.println(coffee);
        }
    }

}

interface Addable<T> {
    void add(T t);
}