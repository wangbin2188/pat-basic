package thinking_in_java.chapter16;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by wangbin10 on 2019/1/29.
 * 数组的实用方法：
 * System.copyArray()
 * Arrays.fill()
 * Arrays.sort()
 * Arrays.binarySearch()
 * Arrays.equals()
 * Arrays.toString()
 * Arrays.asList()
 * Arrays.deepToString()
 */
public class CopingArrays {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 8);
        Arrays.fill(j,14);
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(j));
        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println(Arrays.toString(j));
        System.out.println(Arrays.equals(i, j));
        String[] myStr = new String[10];
        myStr = Generated.array(myStr, new CountingGenerator.String(myStr.length));
        System.out.println(Arrays.toString(myStr));
        Arrays.sort(myStr);
        System.out.println(Arrays.toString(myStr));
        int index = Arrays.binarySearch(myStr, "abcdefghij");
        System.out.println(index);
        Arrays.sort(myStr,String.CASE_INSENSITIVE_ORDER);//忽略大小写的排序
        System.out.println(Arrays.toString(myStr));

    }
}
