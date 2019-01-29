package thinking_in_java.chapter17;

import thinking_in_java.chapter15.Generator;

import java.util.LinkedHashMap;

/**
 * Created by wangbin10 on 2019/1/29.
 */
public class MapData<K,V> extends LinkedHashMap<K, V> {
    /**
     * 三种构造方法
     * @param gen
     * @param quantity
     */
    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> p = gen.next();
            put(p.key, p.value);
        }
    }

    public MapData(Generator<K> genK, Generator<V> genV,int quantity) {
        for (int i = 0; i < quantity; i++) {
            K k = genK.next();
            V v = genV.next();
            put(k,v);
        }
    }

    public MapData(Iterable<K> genK, Generator<V> genV) {
        for (K k : genK) {
            put(k, genV.next());
        }
    }

    /**
     * 三种工厂方法
     * @param gen
     * @param quantity
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity) {
        return new MapData<K, V>(gen, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> genK, Generator<V> genV,int quantity) {
        return new MapData<K, V>(genK,genV, quantity);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> genK, Generator<V> genV) {
        return new MapData<K, V>(genK, genV);
    }
}
