package thinking_in_java.chapter6;

public class Range {
    public static int[] range(int n) {
        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    public static int[] range(int start, int end) {
        int[] result = new int[end - start];
        for (int i = 0; i < result.length; i++) {
            result[i] = start + i;
        }
        return result;
    }

    public static int[] range(int start, int end, int step) {
        int sz = (end - start) / step;
        int[] result = new int[sz];
        for (int i = 0; i < sz; i++) {
            result[i] = start + (i * step);
        }
        return result;
    }
}
