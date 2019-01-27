package thinking_in_java.chapter15;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    private ArrayList<T> storage=new ArrayList<T>();
    private Random rand=new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }



    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        String str = "how are you java";
        for (String s : str.split(" ")) {
            rs.add(s);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(rs.select());
        }
    }
}
