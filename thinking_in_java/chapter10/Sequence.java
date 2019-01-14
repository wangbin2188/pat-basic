package thinking_in_java.chapter10;

/**
 * Created by wangbin10 on 2019/1/14.
 * 这是迭代器设计模式的具体实现
 * 内部类自动获取了其所在外部类所有成员的访问权
 */
public class Sequence {
    private Object[] items;
    private int next=0;

    public Sequence(int size) {
        this.items = new Object[size];
    }

    public void add(Object o) {
        if (next < items.length) {
            items[next++]=o;
        }
    }

    private class SequenceSelector implements Selector {
        private int i=0;
        @Override
        public boolean end() {
            return items.length==i;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(i);
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }

}

interface Selector {
    boolean end();
    Object current();
    void next();
}