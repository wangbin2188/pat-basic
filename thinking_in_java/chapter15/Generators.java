package thinking_in_java.chapter15;

import java.util.ArrayList;
import java.util.Collection;

public class Generators {
    public static <T> Collection<T> fill(Collection<T> col, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            col.add(gen.next());
        }
        return col;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffee) {
            System.out.println(c);
        }

        Collection<Integer> numbers = fill(new ArrayList<Integer>(), new Fibonacci(), 10);
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}
