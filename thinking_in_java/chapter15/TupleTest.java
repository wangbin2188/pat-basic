package thinking_in_java.chapter15;

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("hi", 47);
    }

    static ThreeTuple<String, String, Integer> g() {
        return new ThreeTuple<>("1", "2", 47);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> f = f();
        System.out.println(f);

        ThreeTuple<String, String, Integer> g = g();
        System.out.println(g);
    }
}
