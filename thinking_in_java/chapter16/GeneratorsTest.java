package thinking_in_java.chapter16;

import thinking_in_java.chapter15.Generator;

/**
 * Created by wangbin10 on 2019/1/29.
 */
public class GeneratorsTest {
    public static int size = 10;

    public static void test(Class<?> classes) {
        for (Class<?> type : classes.getClasses()) {
            System.out.print(type.getSimpleName() + ":");
            try {
                Generator<?> g = (Generator<?>) type.newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.print(g.next() + " ");
                }
                System.out.println();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        test(CountingGenerator.class);
        test(RandomGenerator.class);
    }
}
