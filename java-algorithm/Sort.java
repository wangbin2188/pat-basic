package algorithm;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by wangbin10 on 2018/9/12.
 */
public class Sort {
    public static void main(String[] args) {
        Integer[] myArray = {67, 8, 4, 34, 86, 87, 6, 45, 7, 864, 56, 1, 3, 78, 9, 13};
        heapSort3(myArray);
        printArray(myArray);
    }

    /**
     * 基数排序
     */
    public static void radixSort(Integer[] myArray) {
        int max = getMaxNum(myArray);
        int count = getDigit(max);
        for (int i = 1; i <= count; i++) {
            innerRadixSort(myArray, i);
        }
    }

    private static void innerRadixSort(Integer[] myArray, int digit) {
        Integer[][] temp = new Integer[10][20];
        for (int i = 0; i < myArray.length; i++) {
            int row_index = getDigitNum(myArray[i], digit);
            for (int j = 0; j < temp[0].length; j++) {
                if (temp[row_index][j] == null) {
                    temp[row_index][j] = myArray[i];
                    break;
                }
            }
        }
        int k = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                if (temp[i][j] != null) {
                    myArray[k++] = temp[i][j];
                }
            }
        }
    }

    private static int getDigit(int max) {
        int count = 1;
        while (max / 10 != 0) {
            count++;
            max /= 10;
        }
        return count;
    }

    private static int getMaxNum(Integer[] myArray) {
        int max = 0;
        for (int i = 0; i < myArray.length; i++) {
            if (max < myArray[i]) {
                max = myArray[i];
            }
        }
        return max;
    }

    /**
     * 获取指定数字对应位上的数值
     */
    private static Integer getDigitNum(Integer x, Integer digit) {
        int divisor = (int) Math.pow(10, digit - 1);
        return (x / divisor) % 10;
    }

    /**
     * 堆排序
     */
    public static void heapSort(Integer[] myArray) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < myArray.length; i++) {
            q.offer(myArray[i]);
        }
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = q.poll();
        }
    }

    public static void heapSort2(Integer[] myArray) {
        BinaryHeap<Integer> q = new BinaryHeap<>(myArray);

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = q.deleteMin();
        }
    }

    public static void heapSort3(Integer[] myArray) {
        BinaryHeap<Integer> q = new BinaryHeap<>();
        for (int i = 0; i < myArray.length; i++) {
            q.insert(myArray[i]);
        }
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = q.deleteMin();
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(Integer[] myArray) {
        int i, j;
        for (i = 1; i < myArray.length; i++) {
            int temp = myArray[i];
            for (j = i; j > 0; j--) {
                if (temp < myArray[j - 1]) {
                    myArray[j] = myArray[j - 1];
                } else {
                    break;
                }
            }
            myArray[j] = temp;
        }
    }

    /**
     * 希尔排序就是多趟插入排序，区别在于由于每趟的步长不同，所有进行插入对比的时候比较的数据不是相邻的
     */
    public static void shellSort(Integer[] myArray) {
        int i, j, step;
        for (step = myArray.length / 2; step > 0; step = step / 2) {
            for (i = step; i < myArray.length; i = i + step) {
                int temp = myArray[i];
                for (j = i; j >= step; j = j - step) {
                    if (temp < myArray[j - step]) {
                        myArray[j] = myArray[j - step];
                    } else {
                        break;
                    }
                }
                myArray[j] = temp;
            }
        }
    }

    /**
     * 选择排序
     */
    public static void selectSort(Integer[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            int min_index = i;
            for (int j = i; j < myArray.length; j++) {
                if (myArray[j] < myArray[min_index]) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                int temp = myArray[i];
                myArray[i] = myArray[min_index];
                myArray[min_index] = temp;
            }
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(Integer[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length - 1 - i; j++) {
                if (myArray[j] > myArray[j + 1]) {
                    int temp = myArray[j];
                    myArray[j] = myArray[j + 1];
                    myArray[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(Integer[] myArray, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int key = myArray[i];
        while (i < j) {
            while (i < j && myArray[j] > key) {
                j--;
            }
            myArray[i] = myArray[j];
            while (i < j && myArray[i] < key) {
                i++;
            }
            myArray[j] = myArray[i];
        }
        myArray[i] = key;
        quickSort(myArray, left, i - 1);
        quickSort(myArray, i + 1, right);
    }

    /**
     * 归并排序
     */
    public static void mergeSort(Integer[] myArray, int low, int high) {
        if (low >= high) {
            return;
        } else {
            int mid = (low + high) / 2;
            mergeSort(myArray, low, mid);
            mergeSort(myArray, mid + 1, high);
            merge(myArray, low, mid, high);
        }

    }

    private static void merge(Integer[] myArray, int low, int mid, int high) {
        Integer[] temp = new Integer[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (myArray[i] < myArray[j]) {
                temp[k++] = myArray[i++];
            } else {
                temp[k++] = myArray[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = myArray[i++];
        }
        while (j <= high) {
            temp[k++] = myArray[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            myArray[low + x] = temp[x];
        }
    }

    public static void printArray(Integer[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.format("%d,", myArray[i]);
        }
        System.out.println();
    }
}
