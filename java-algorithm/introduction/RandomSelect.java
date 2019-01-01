package sort;

import static sort.QuickSort.randomPartition;


/**
 * 《算法导论》第九章查找一个数列中第i小的元素：
 * 1.采用递归查找方法，首先将数组分为两个部分，其中左边小于key,右边都大于key
 * 2.然后再两边再递归查找第i/i-k的元素
 * */
public class RandomSelect {
    public static void main(String[] args) {
        Integer [] myArray= {1, 8, 3, 6, 7, 4, 2, 9};
        int num = randomSelect(myArray, 0, myArray.length - 1, 5);
        System.out.println(num);
    }

    public static int randomSelect(Integer[] array, int low, int high, int i) {
        if (low == high) {
            return array[low];
        }
        int q=randomPartition(array,low,high);
        int k=q-low+1;
        if (i == k) {
            return array[q];
        } else if (i < k) {
            return randomSelect(array, low, q - 1, i);
        }else{
            return randomSelect(array, q + 1, high, i - k);
        }
    }


}
