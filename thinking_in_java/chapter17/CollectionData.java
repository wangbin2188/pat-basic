
package thinking_in_java.chapter17;

import thinking_in_java.chapter15.Generator;

import java.util.ArrayList;

/**
 * CollectionData是适配器设计模式的一个实例，他将Generator适配到Collection的构造器上
 * 通过Generator产生quantity数个对象
 * */
public class CollectionData<T> extends ArrayList<T> {
    /**
     * 构造方法
     * @param gen
     * @param quantity
     */
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    /**
     * 构造函数的工厂方法
     * @param gen
     * @param quantity
     * @param <T>
     * @return
     */
    public static <T> CollectionData<T>    list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
} ///:~
