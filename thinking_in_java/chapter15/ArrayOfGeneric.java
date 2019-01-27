package thinking_in_java.chapter15;

public class ArrayOfGeneric {
    static final int SIZE=100;
    static Generic<Integer> [] gia;

    public static void main(String[] args) {
        gia = new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
    }
}
