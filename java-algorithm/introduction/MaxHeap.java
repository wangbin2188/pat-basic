package introduction;

import static introduction.Utils.swap;

/**
 * 《算法导论》第六章堆排序
 * @param <T>
 */
public class MaxHeap<T extends Comparable<? super T>> {
    private int curSize;
    private T[] array;

    /**
     * 从一个数组构造一个大顶堆
     * @param array
     */

    public MaxHeap(T[] array) {

        this.array = (T[]) new Comparable[2*array.length + 1];

        for (int i = 0; i < array.length; i++) {
            this.array[i + 1] = array[i];
        }
        this.curSize = array.length;
        buildMaxHeap();
    }

    /**
     * 递归的调整元素，使得数组中元素的顺序符合堆的性质
     * @param index
     */

    private void maxHeapify(int index) {

        int leftIndex = 2 * index;
        int rightIndex = 2 * index + 1;
        int largest;
        if (leftIndex <= curSize && array[leftIndex].compareTo(array[index]) > 0) {
            largest = leftIndex;
        } else {
            largest = index;
        }

        if (rightIndex <= curSize && array[rightIndex].compareTo(array[largest]) > 0) {
            largest = rightIndex;
        }

        if (largest != index) {
            swap(array, largest, index);
            maxHeapify(largest);
        }

    }


    /**
     * 对非叶子节点使用maxHeapify(),使得满足堆的性质
     */
    private void buildMaxHeap() {

        for (int i = curSize / 2; i >= 1; i--) {
            maxHeapify(i);
        }
    }

    /**
     * 堆排序：弹出堆顶元素，依次放入数组中，使得最终数组是有序的
     */
    public void heapSort() {
        buildMaxHeap();
        for (int i = curSize; i >= 2; i--) {
            swap(array, 1, i);
            curSize--;
            maxHeapify(1);
        }
    }

    public void printArray() {
        for (int i = 1; i <=curSize; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }


    public T findMax() {
        return array[1];
    }

    public T deleteMax(){
        T max=array[1];
        array[1]=array[curSize];
        curSize--;
        maxHeapify(1);
        return max;
    }

    /**
     * 增加一个元素的key,并进行调整，使得继续保持堆的性质
     * @param index
     * @param key
     */
    public void increaseKey(int index,T key){
        if(key.compareTo(array[index])<0){
            return;
        }
        array[index]=key;
        while (index>1 && array[index/2].compareTo(array[index])<0){
            swap(array,index,index/2);
            index=index/2;
        }

    }

    /**
     * 向堆中插入新元素，这里未考虑底层数组容量问题
     * @param key
     */
    public void insert(T key){
        curSize++;
        array[curSize]=key;
        increaseKey(curSize,key);
    }

    public static void main(String[] args) {
        Integer[] myArray = {1, 8, 3, 6, 7, 4, 2, 9, 5};
        MaxHeap<Integer> integerMaxHeap = new MaxHeap<>(myArray);
        integerMaxHeap.printArray();
        integerMaxHeap.insert(11);
        integerMaxHeap.printArray();
    }
}
