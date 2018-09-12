package algorithm;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by wangbin10 on 2018/9/12.
 * 自定义双向链表，底层以内部类Node实现，链表本身包含头指针和尾指针
 */
public class MyLinkedList<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    public static class Node<T> {
        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public T data;
        public Node<T> prev;
        public Node<T> next;
    }

    public MyLinkedList() {
        doClear();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T t) {
        add(size(), t);
        return true;
    }

    private void add(int index, T t) {
        addBefore(getNode(index, 0, size), t);
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, beginMarker, null);
        beginMarker.next = endMarker;
        size = 0;
        modCount++;
    }

    private void addBefore(Node<T> t, T x) {
        Node<T> newNode = new Node<>(x, t.prev, t);
        newNode.prev.next = newNode;
        t.prev = newNode;
        size++;
        modCount++;
    }

    private T remove(Node<T> t) {
        t.prev.next = t.next;
        t.next.prev = t.prev;
        size--;
        modCount++;
        return t.data;
    }

    private Node<T> getNode(int index) {
        return getNode(index, 0, size() - 1);
    }

    private Node<T> getNode(int index, int lower, int upper) {
        Node<T> t;
        if (index < lower || index > upper) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size() / 2) {
            t = beginMarker.next;
            for (int i = 0; i < index; i++) {
                t = t.next;
            }
        } else {
            t = endMarker;
            for (int i = size(); i > index; i--) {
                t = t.prev;
            }
        }
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = beginMarker.next;
            /**访问和修改的互斥锁*/
            private int expectedModCount = modCount;
            private boolean okToRemove = false;

            @Override
            public boolean hasNext() {
                return current != endMarker;
            }

            @Override
            public T next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T nextItem = current.data;
                current = current.next;
                okToRemove = true;
                return nextItem;
            }

            public void remove() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!okToRemove) {
                    throw new IllegalStateException();
                }
                MyLinkedList.this.remove(current.prev);
                expectedModCount++;
                okToRemove = false;
            }
        };
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList=new MyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            myLinkedList.add(i);
        }
        myLinkedList.add(3, 9);
        Node<Integer> node = myLinkedList.getNode(2);
        myLinkedList.addBefore(node,8);
        myLinkedList.remove(node);
        for (Integer integer : myLinkedList) {
            System.out.println(integer);
        }
    }
}
