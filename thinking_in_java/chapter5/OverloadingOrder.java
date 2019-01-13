package thinking_in_java.chapter5;

public class OverloadingOrder {
    static void f(String s, int i) {
        System.out.println("string=" + s + " int =" + i);
    }

    static void f(int i, String s) {
        System.out.println("int ="+i+" string="+s);
    }

    public static void main(String[] args) {
        f(1, "alice");
        f("bob", 2);
    }
}
