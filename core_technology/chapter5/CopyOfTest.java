package core_technology.chapter5;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by wangbin10 on 2019/1/3.
 * 使用反射机制实现泛型数组，Array.newInstance(数组元素类型，数组长度)
 */
public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 4};
        a = (int[])goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"alice", "bob", "cls"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

    }

    private static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if (!cl.isArray()) {
            return null;
        }
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }

}
