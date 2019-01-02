package introduction;

/**
 * Created by wangbin10 on 2018/12/29.
 */
public class Utils {
    public static <T> void swap(T[] array, int x, int y) {
        T temp = array[x];
        array[x]=array[y];
        array[y]=temp;
    }
}
