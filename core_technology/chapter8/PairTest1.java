package chapter8;

public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"mary", "has", "a", "little", "lamb"};
        Pair<String> minmax = ArrayAlg.minmax(words);
        System.out.println(minmax.getFirst());
        System.out.println(minmax.getSecond());
    }
}

class ArrayAlg {
    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min=a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }

        }
        return new Pair<>(min, max);
    }
}


