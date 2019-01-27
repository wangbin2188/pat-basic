package thinking_in_java.chapter15;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericArrayWithTypeToken<T> {
    private T[] array;

    public GenericArrayWithTypeToken(Class<T> type,int sz) {
        this.array = (T[]) Array.newInstance(type,sz);
    }

    public void put(int index, T item) {
        array[index]=item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> array = new GenericArrayWithTypeToken<>(Integer.class, 10);
        for (int i = 0; i < 10; i++) {
            array.put(i,i);
        }
        Integer[] rep = array.rep();
        System.out.println(Arrays.toString(rep));
    }
}
