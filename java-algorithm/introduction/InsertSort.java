package introduction;

/**
 * Created by wangbin10 on 2018/12/14.
 * 简单插入排序，含升序和降序两个方法
 */
public class InsertSort {
    public static void main(String[] args) {
        Integer[] myArray = {67, 8, 4, 34, 86, 87, 6, 45, 7, 864, 56, 1, 3, 78, 9, 13};
        String i = findArray(myArray, 19);
        System.out.println(i);
    }

    public static Integer [] insertSort(Integer [] myArray){
        int i,j;
        for ( i = 1; i < myArray.length; i++) {
            Integer temp = myArray[i];
            for ( j = i; j > 0; j--) {
                if (temp < myArray[j - 1]) {
                    myArray[j] = myArray[j - 1];
                }else{
                    break;
                }
            }
            myArray[j]=temp;
        }
        return myArray;
    }

    public static Integer [] reverseInsertSort(Integer [] myArray){
        int i,j;
        for ( i = 1; i < myArray.length; i++) {
            int temp = myArray[i];
            for (j = i; j > 0; j--) {
                if (temp > myArray[j - 1]) {
                    myArray[j] = myArray[j - 1];
                } else {
                    break;
                }
            }
            myArray[j]=temp;
        }
        return myArray;
    }

    public static void printArray(Integer[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.format("%d,", myArray[i]);
        }
        System.out.println();
    }

    public static String findArray(Integer[] myArray, Integer value) {
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i].equals(value)) {
                return String.valueOf(i);
            }
        }
        return "NIL";
    }
}
