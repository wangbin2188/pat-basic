package thinking_in_java.chapter15;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangbin10 on 2019/1/28.
 */
public class SimpleQueue<T> implements Iterable<T> {
    private Queue<T> storage = new LinkedList<T>();

    public void add(T t) {
        storage.offer(t);
    }

    public T get() {
        return storage.poll();
    }

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
}
