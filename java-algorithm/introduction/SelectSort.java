package introduction;


import java.util.Arrays;

import static introduction.Utils.swap;

/**
 * Created by wangbin10 on 2018/12/29.
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        Integer[] myArray = {67, 8, 4, 34, 86, 87, 6, 45, 7, 864, 56, 1, 3, 78, 9, 13};
        selectSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    private static <T extends Comparable> void selectSort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int min_index = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j].compareTo(array[min_index]) <0 ) {
                    min_index = j;
                }
            }
            swap(array, i, min_index);
        }
    }
}
