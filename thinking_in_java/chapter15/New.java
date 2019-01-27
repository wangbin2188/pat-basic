package thinking_in_java.chapter15;

import java.util.*;

public class New {
    public static <K,V> Map<K,V> map() {
        return new HashMap<K,V>();
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    public static <T> Set<T> set() {
        return new HashSet<>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = New.map();
        List<String> list = New.list();
        Set<Integer> set = New.set();
    }
}
