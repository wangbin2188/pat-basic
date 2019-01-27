package thinking_in_java.chapter15;

public class Coffee {
    private static long counter=0;
    public final long id=counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{id=" + id +
                '}';
    }
}
