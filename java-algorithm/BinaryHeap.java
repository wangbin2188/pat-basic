package algorithm;


/**
 * Created by wangbin10 on 2018/9/13.
 */
public class BinaryHeap<T extends Comparable<? super T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private T[] array;

    public BinaryHeap() {
        array = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public BinaryHeap(int capacity) {
        if (capacity <= DEFAULT_CAPACITY) {
            array = (T[]) new Comparable[DEFAULT_CAPACITY];
        }
        array = (T[]) new Comparable[capacity];
    }

    public BinaryHeap(T[] items) {
        currentSize = items.length;
        array = (T[]) new Comparable[(currentSize + 2) * 11 / 10];
        int i = 1;
        for (T item : items) {
            array[i++] = item;
        }
        buildHeap();
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    /**
     * 渗透：如果新插入的节点（hole是节点在数组中的下标）大于其子节点，则将其与较小子节点交换，知道不再有子节点小于自己
     */
    private void percolateDown(int hole) {
        int child;
        T tmp = array[hole];
        for (; hole * 2 < currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }
            if (array[child].compareTo(tmp) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }

    /**
     * 将节点插入小顶堆：
     * 1.若数组空间不足，则扩充为原来的两倍+1；
     * 2.将新节点x暂存，下标暂为数组的末尾下标；
     * 3.如果x节点小于末尾节点的父节点，则将父节点复制到子节点上；
     * 4.直到满足x的父节点不大于x,则将x插入当前位置
     */
    public void insert(T x) {
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
        }
        int hole = ++currentSize;
        /**array[0]=x?何解，如果不把x赋值给array[0],那么array[0]就是null*/
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole = hole / 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }

    private void enlargeArray(int hole) {
        T[] tmp = array;
        array = (T[]) new Comparable[hole];
        int i = 1;
        for (T t : tmp) {
            array[i++] = t;
        }
    }

    public T deleteMin() {
        T minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    private T findMin() {
        return array[1];
    }
}
