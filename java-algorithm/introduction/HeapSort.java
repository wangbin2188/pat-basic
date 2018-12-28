package introduction;

import static introduction.InsertSort.printArray;

/**
 * Created by wangbin10 on 2018/12/17.
 * 构建大顶堆,所有父元素一定大于子元素
 */
public class HeapSort<T extends Comparable<? super T>> {
    private final static int CAPACITY = 10;
    private int curSize;
    private T[] array;

    /**
     * 三个构造方法：
     * 1.无参构造方法，构造基于默认容量的泛型数组
     * 2.指定容量构造方法，构造基于指定容量的泛型数组
     * 3.传入原始数组的构造方法，创建新array，将原始数组copy到新array中，并构造堆
     */
    public HeapSort() {
        this.array = (T[]) new Comparable[CAPACITY];
    }

    public HeapSort(int capacity) {
        if (capacity < CAPACITY) {
            this.array = (T[]) new Comparable[CAPACITY];
        }
        this.array = (T[]) new Comparable[capacity];
    }

    /**
     * 向堆中插入元素：
     * 1.插入新元素前进行判断，如果堆元素即将充满数组，则对数组进行扩容；
     * 2.数组中实际元素数+1，并将其作为新元素下标（也就是说新元素都是插在堆尾的，这样不会破坏堆的性质）；
     * 3.堆尾元素未必是最小的，因此对堆尾元素的实际位置进行调整
     */
    public void insert(T x) {
        if (curSize == array.length - 1) {
            enlargeArray(2 * curSize + 1);
        }
        int curIndex = ++curSize;
        /**将x插入到堆尾(curIndex),然后上浮调整位置*/
        up(x, curIndex);
    }

    /**
     * 上浮就是当前元素和自己的父节点元素进行比较，对于当前的大顶堆：
     * 1.如果当前元素大于父节点，则两者进行交换，（简单来说是将父元素赋值到当前元素位置，当前元素已缓存，不担心被覆盖）
     * 2.直到不再满足迭代的条件（1.父元素大于当前元素；2.当前元素已到堆顶）
     * 3.将已缓存的当前元素插入到指定位置
     */
    private void up(T x, int curIndex) {
        array[0] = x;//没有这个赋值，就会出现空指针异常
        //元素一直上浮，（最高可到堆顶）
        for (; x.compareTo(array[curIndex / 2]) > 0 && curIndex >= 1; curIndex /= 2) {
            array[curIndex] = array[curIndex / 2];
        }
        //找到合适位置将x插入
        array[curIndex] = x;
    }

    /**
     * 扩容数组非常简单，将原数组中的元素直接复制到新数组即可
     */
    private void enlargeArray(int newSize) {
        T[] tmp = array;
        array = (T[]) new Comparable[newSize];
        for (int i = 1; i < tmp.length; i++) {
            array[i] = tmp[i];
        }
    }

    /**
     * 1.删除堆顶元素，然后把堆尾元素赋给堆顶；
     * 2.调整堆
     */
    public T deleteMax() {
        T t = array[1];
        array[1] = array[curSize--];
        down(1);
        return t;
    }

    /**
     * 下沉操作与上浮操作相比，稍有不同，主要是父节点需要跟较大的子节点进行对比并交换，才能实现大顶堆；
     * 1.首先定义当前节点下标和其子节点child（此时并未确定是左子节点还是右子节点）；
     * 2.如果child未超出元素下标范围，则对左右两节点大小进行比较，取较大一个的下标赋值给child;
     * 3.如果较大子节点大于当前节点，则将子节点的值赋值给当前节点位置，否则跳出for循环
     */
    private void down(int index) {
        int child;
        T tmp = array[index];
        /**
         * for循环中，前面两个条件先执行，满足条件的话，大括号中的内容执行，最后第三个语句才执行;
         * 因此这个child虽然没有初始化也可以赋值给index,是因为在赋值真正执行的时候child已经初始化了；
         * */
        for (; index * 2 < curSize; index = child) {
            child = index * 2;
            if (child != curSize && array[child + 1].compareTo(array[child]) > 0) {
                child++;
            }
            if (array[child].compareTo(tmp) > 0) {
                array[index] = array[child];
            } else {
                break;
            }
        }
        array[index] = tmp;
    }


    public static void main(String[] args) {
        Integer[] myArray = {1, 5, 9, 6, 7, 8, 2, 3, 4,5};
        HeapSort<Integer> maxHeap = new HeapSort<>();
        for (int i = 0; i < myArray.length; i++) {
            maxHeap.insert(myArray[i]);
        }
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = maxHeap.deleteMax();
        }
        printArray(myArray);

    }

}
