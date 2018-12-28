package introduction;

import static introduction.InsertSort.printArray;

/**
 * Created by wangbin10 on 2018/12/17.
 */
public class BubbleSort {
    public static void main(String[] args) {
        Integer[] myArray = {67, 8, 4, 34, 86, 87, 6, 45, 7, 864, 56, 1, 3, 78, 9, 13};
        bubble_sort(myArray);
        printArray(myArray);
    }

    private static void bubble_sort(Integer[] myArray) {
        int n=0;
        for (int m=0;m<myArray.length;m++) {
            for (int i = 1; i < myArray.length-m; i++) {
                if (myArray[i] < myArray[i - 1]) {
                    int temp = myArray[i];
                    myArray[i]=myArray[i-1];
                    myArray[i-1]=temp;
                }
            }
        }

    }


}
