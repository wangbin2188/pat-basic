package introduction;


import java.util.Arrays;

import static introduction.Utils.swap;

/**
 * Created by wangbin10 on 2018/12/17.
 */
public class BubbleSort {
    public static void main(String[] args) {
        Integer[] myArray = {67, 8, 4, 34, 86, 87, 6, 45, 7, 864, 56, 1, 3, 78, 9, 13};
        bubble_sort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    private static<T extends Comparable> void bubble_sort(T [] array) {

        for (int m=0;m<array.length;m++) {
            for (int i = 1; i < array.length-m; i++) {
                if (array[i].compareTo(array[i - 1])<0) {
                    swap(array, i, i - 1);
                }
            }
        }
    }


}
