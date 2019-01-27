package thinking_in_java.chapter15;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {
    public static <T> List<T> makeList(T... args) {
        ArrayList<T> ts = new ArrayList<>();
        for (T arg : args) {
            ts.add(arg);
        }
        return ts;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("a", "b", "c");
        System.out.println(ls);
        ls=makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
    }
}
