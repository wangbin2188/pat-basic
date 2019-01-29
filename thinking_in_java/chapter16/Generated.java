package thinking_in_java.chapter16;

import thinking_in_java.chapter15.Generator;
import thinking_in_java.chapter17.CollectionData;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by wangbin10 on 2019/1/29.
 * 两种方法创建泛型数组
 */
public class Generated {
    /**
     * 创建一个容器类，然后转化成数组
     * @param a
     * @param gen
     * @param <T>
     * @return
     */
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new CollectionData<T>(gen, a.length).toArray(a);
    }

    /**
     * 使用Array.newInstance创建泛型数组
     * @param type
     * @param gen
     * @param size
     * @param <T>
     * @return
     */
    public static <T> T[] array(Class<T> type,Generator<T> gen,int size) {
        T[] a = (T[]) Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(a);
//        return a;//这样是个空数组，上面是填充后的数组
    }

    public static void main(String[] args) {
        Integer[] b = {9, 8, 7, 6};
        System.out.println(Arrays.toString(b));
        b=Generated.array(b,new CountingGenerator.Integer());
        System.out.println(Arrays.toString(b));
        Integer[] c = Generated.array(Integer.class, new CountingGenerator.Integer(), 10);
        System.out.println(Arrays.toString(c));
        int[] ints = ConvertTo.primitive(c);
        System.out.println(Arrays.toString(ints));
    }
}
