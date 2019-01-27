package thinking_in_java.chapter15;

import static thinking_in_java.chapter15.Tuple.tuple;

public class TupleTest2 {
    static TwoTuple<String,Integer> f() {
        return tuple("hi", 47);
    }

    static ThreeTuple<String,String,Integer> g() {
        return tuple("a", "b", 47);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> f = f();
        System.out.println(f);
        ThreeTuple<String, String, Integer> g = g();
        System.out.println(g);
    }
}
