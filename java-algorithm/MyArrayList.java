package algorithm;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by wangbin10 on 2018/9/12.
 * 自定义ArrayList，基于数组
 */
public class MyArrayList<T> implements Iterable<T> {
    /**
     * 初始容量
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 元素个数
     */
    private int size;
    private T[] items;

    public MyArrayList() {
        doClear();
    }

    private void doClear() {
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[index];
    }

    public T set(int index, T t) {
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = items[index];
        items[index] = t;
        return old;

    }

    /**
     * 这是ArrayList优于数组的地方，当底层容量不足时，自动扩充容量
     * 原理是创建一个比原来数组更大的数组，将原数组拷贝到新数组
     */
    private void ensureCapacity(int newCapacity) {
        if (newCapacity < size) {
            return;
        }
        T[] old = items;
        items = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            items[i] = old[i];
        }
    }

    public boolean add(T t) {
        add(size(), t);
        return true;
    }

    private void add(int index, T t) {
        if (items.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = t;
        size++;
    }

    public T remove(int index) {
        T t = items[index];
        for (int i = index; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < size();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return items[current++];
            }

            public void remove() {
                MyArrayList.this.remove(--current);
            }
        };
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList=new MyArrayList<>();
        for (int i=0;i<20;i++) {
            myArrayList.add(i);
        }
        myArrayList.add(5, 99);
        for (Integer integer : myArrayList) {
            System.out.println(integer);
        }
    }
}
