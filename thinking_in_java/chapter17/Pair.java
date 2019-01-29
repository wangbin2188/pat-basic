package thinking_in_java.chapter17;

/**
 * Created by wangbin10 on 2019/1/29.
 */
public class Pair<K, V> {
    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
