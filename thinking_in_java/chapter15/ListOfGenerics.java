package thinking_in_java.chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * 不能创建泛型数组，一般的解决方案是使用ArrayList替代
 * @param <T>
 */
public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<T>();

    public void add(T item) {
        array.add(item);
    }

    public T get(int index) {
        return array.get(index);
    }
}
