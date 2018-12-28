package introduction;

/**
 * Created by wangbin10 on 2018/12/14.
 * 合并两个排序的数据进入一个新数组，并保存顺序
 */
public class MergeSort {
    public static void main(String[] args) {
        /*Integer[] xArray = {1, 3, 7, 9, 13, 56};
        Integer[] yArray = {4, 6, 8, 34, 45, 67, 86, 87};
        Integer[] array = mergeArray(xArray, yArray);
        printArray(array);*/
        Integer[] myArray = {1, 3, 7, 9, 13, 56, 4, 6, 8, 34, 45, 67, 86, 87};
        mergeArray2(myArray, 0, 5, 13);
        printArray(myArray);
    }

    public static Integer[] mergeArray(Integer[] x, Integer[] y) {
        int len = x.length + y.length;
        Integer[] zArray = new Integer[len];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < x.length && j < y.length) {
            if (x[i] < y[j]) {
                zArray[k++] = x[i++];
            } else {
                zArray[k++] = y[j++];
            }
        }

        while (i < x.length) {
            zArray[k++] = x[i++];
        }

        while (j < y.length) {
            zArray[k++] = y[j++];
        }

        return zArray;
    }

    public static void printArray(Integer[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.format("%d,", myArray[i]);
        }
        System.out.println();
    }

    /*合并两个有序的数组，并保持有序*/
    public static void mergeArray2(Integer[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        Integer[] b = new Integer[high - low + 1];
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
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
