package introduction;

import java.util.Arrays;

/**
 * Created by wangbin10 on 2018/12/14.
 * 合并两个排序的数据进入一个新数组，并保存顺序
 */
public class MergeSort {
    public static void main(String[] args) {
        Integer[] myArray = {1, 3, 7, 9, 13, 56, 4, 6, 8, 34, 45, 67, 86, 87};
        mergeArray2(myArray, 0, 5, 13);
        System.out.println(Arrays.toString(myArray));
    }


    /*合并两个有序的数组，并保持有序*/
    public static <T extends Comparable> void mergeArray2(T[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        T[] b = (T[]) new Comparable[high - low + 1];
        while (i <= mid && j <= high) {
            if (a[i].compareTo(a[j]) < 0) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }

        while (i <= mid) {
            b[k++] = a[i++];
        }

        while (j <= high) {
            b[k++] = a[j++];
        }

        for (int x = 0; x < b.length; x++) {
            a[low + x] = b[x];
        }
    }
}
