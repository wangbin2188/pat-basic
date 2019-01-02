package introduction;

import java.util.Arrays;

/**
 * Created by wangbin10 on 2018/12/14.
 * 简单插入排序，含升序和降序两个方法
 */
public class InsertSort {
    public static void main(String[] args) {
        Integer[] myArray = {67, 8, 4, 34, 86, 87, 6, 45, 7, 864, 56, 1, 3, 78, 9, 13};
        System.out.println(Arrays.toString(myArray));
        insertSort(myArray);
        System.out.println(Arrays.toString(myArray));
        reverseInsertSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    public static <T extends Comparable> void insertSort(T [] myArray){
        int i,j;
        for ( i = 1; i < myArray.length; i++) {
            T temp = myArray[i];
            for ( j = i; j > 0; j--) {
                if (temp.compareTo(myArray[j - 1])<0 ) {
                    myArray[j] = myArray[j - 1];
                }else{
                    break;
                }
            }
            myArray[j]=temp;
        }
    }

    public static <T extends Comparable> void reverseInsertSort(T [] myArray){
        int i,j;
        for ( i = 1; i < myArray.length; i++) {
            T temp = myArray[i];
            for (j = i; j > 0; j--) {
                if (temp.compareTo(myArray[j - 1])>0 ) {
                    myArray[j] = myArray[j - 1];
                } else {
                    break;
                }
            }
            myArray[j]=temp;
        }
    }



    public static <T> String findArray(T [] myArray, Integer value) {
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i].equals(value)) {
                return String.valueOf(i);
            }
        }
        return "NIL";
    }
}
