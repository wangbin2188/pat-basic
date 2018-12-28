package introduction;


import static introduction.InsertSort.printArray;

/**
 * Created by wangbin10 on 2018/12/28.
 * 算法来自《算法导论》采用分治法求解最大子数组，思路如下：
 * 一.取一个中间下标mid=(low+high)/2,则最大子数组只可能有三种情况：
 * 1.不包含mid,且在mid左边；
 * 2.不包含mid,且在mid右边；
 * 3.包含mid
 * 分别对这三种情况求值后，比较最大子数组，即为原始数组的最大子数组
 */
public class MaxSubArray {
    public static void main(String[] args) {
        Integer[] myArray = {67, -8, -4, -34, -86, -87, -6, -45, -7, -64, -56, -1, -3, -78, -9};
        Integer[] crossSubArray = findCrossSubArray(myArray, 0, 7, 14);
        printArray(crossSubArray);
        Integer[] maxSubArray = findMaxSubArray(myArray, 0, 14);
        printArray(maxSubArray);
        int maxArray = findMaxArray(myArray);
        System.out.println(maxArray);
    }

    /**
     * 求包含mid值的最大子数组：
     * 既然包含mid,则可以把这个目标数组以mid为界分为两部分
     * 1.包含mid的左半部分
     * 2.包含mid的右半部分
     * 如果目标数组和最大，则两个半数组必定也是最大
     */
    private static Integer[] findCrossSubArray(Integer[] array, int low, int mid, int high) {
        //左半数组的最大求和
        int maxLeft = Integer.MIN_VALUE;
        //遍历左半数组中每一步的求和
        int curSum = 0;
        //左半数组的左下标
        int maxLeftIndex = mid;
        for (int i = mid; i >= low; i--) {
            curSum = curSum + array[i];
            if (curSum > maxLeft) {
                maxLeft = curSum;
                maxLeftIndex = i;
            }
        }
        //右半数组的最大求和
        int maxRight = Integer.MIN_VALUE;
        //遍历过程中的数组求和
        curSum = 0;
        //右半数组的右下标
        int maxRightIndex = mid;
        for (int j = mid; j <= high; j++) {
            curSum = curSum + array[j];
            if (curSum > maxRight) {
                maxRight = curSum;
                maxRightIndex = j;
            }
        }
        Integer[] newArray = new Integer[maxRightIndex - maxLeftIndex + 1];
        for (int k = 0; k < newArray.length; k++) {
            newArray[k] = array[maxLeftIndex + k];
        }
        return newArray;
    }

    /**
     * 将一个求最大子数组的问题分为三个小问题：
     * 1.求左半子数组（不含mid）的最大子数组；
     * 2.求右半子数组（不含mid）的最大子数组；
     * 3.求跨中间值的最大子数组
     * 三者之间的最大值即为要求的值
     */
    private static Integer[] findMaxSubArray(Integer[] array, int low, int high) {
        if (low == high) {
            return array;
        } else {
            int mid = (low + high) / 2;
            Integer[] left = findMaxSubArray(array, low, mid);
            Integer[] right = findMaxSubArray(array, mid + 1, high);
            Integer[] cross = findCrossSubArray(array, low, mid, high);
            int sumLeft = sumArray(left);
            int sumRight = sumArray(right);
            int sumCross = sumArray(cross);
            if (sumLeft >= sumRight && sumLeft >= sumCross) {
                return left;
            } else if (sumRight >= sumLeft && sumRight >= sumCross) {
                return right;
            } else {
                return cross;
            }
        }
    }

    //遍历数组求和
    private static int sumArray(Integer[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    /**
     * 效率比较高的一种求最大子数组和的方法。
     * 该方法只需要遍历一遍数组，故时间复杂度为O(n)
     * 其中用到这样一个原理，如果一个子数组curSum的和已经小于0，则向后继续加入新元素只会减少后面元素的求和，故这种情况下直接将左边小于0的数组元素抛弃
     */
    private static int findMaxArray(Integer[] array) {
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            curSum += array[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }

}
