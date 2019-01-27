package thinking_in_java.chapter15;

public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public void set(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Integer> holder3 = new Holder3<Integer>(3);
        Integer integer = holder3.get();
        System.out.println(integer);

    }
}
