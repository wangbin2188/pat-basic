package introduction;

import java.util.Arrays;
import java.util.Random;

import static introduction.Utils.swap;

/**
 * 《算法导论》第七章：快速排序
 * 这里的快速排序采用的是递归方法
 */
public class QuickSort {
    public static void main(String[] args) {
        Integer [] myArray= {1, 8, 3, 6, 7, 4, 2, 9, 5};
        randomQuickSort(myArray,0,myArray.length-1);
        System.out.println(Arrays.toString(myArray));
    }

    /**
     * 通过partition方法将数组分为两个部分，分而治之，继续进行快速排序
     * @param array
     * @param low
     * @param high
     */

    public static <T extends Comparable> void quickSort(T [] array,int low,int high) {
        if (low < high) {
            int q=partition(array,low,high);
            quickSort(array,low,q-1);
            quickSort(array,q+1,high);
        }
    }

    /**
     * 从左到右遍历整个数组，使得左半部分都小于key,右半部分都大于key,并返回key所在下标
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static <T extends Comparable> int partition(T [] array, int low, int high) {
        T x=array[high];
        int i=low-1;
        for (int j = low; j <= high - 1; j++) {
            if (array[j].compareTo(x)<=0) {
                i=i+1;
                swap(array,i,j);
            }
        }
        swap(array,i+1,high);
        return i+1;
    }

    /**
     * 改进版快速排序
     * @param array
     * @param low
     * @param high
     */
    public static <T extends Comparable> void randomQuickSort(T [] array,int low,int high) {
        if (low < high) {
            int q = randomPartition(array, low, high);
            randomQuickSort(array,low,q-1);
            randomQuickSort(array,q+1,high);
        }
    }

    /**
     * 改进版划分分区
     * 区别在于不再以最后一个元素作为游标，而是随机选取一个元素，当然还是要把这个游标元素放在最后一个位置
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static <T extends Comparable> int randomPartition(T [] array,int low,int high) {
        Random random = new Random();
        int rand = random.nextInt(high-low+1)+low;
        swap(array,rand,high);
        return partition(array,low,high);
    }




}
