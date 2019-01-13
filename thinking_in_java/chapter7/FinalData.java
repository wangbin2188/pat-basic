package thinking_in_java.chapter7;

import java.util.Random;

/**
 * final基本类型的值永远无法改变
 * final引用类型的引用指向的对象无法改变，但对象的值可以改变
 * final static 的值是常量，只初始化一次，且无法修改
 * 数组也属于引用类型
 * 空白final是允许的，但在使用前必须初始化
 */
public class FinalData {
    public static Random random=new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    private static final int VALUE_ONE=9;
    private final static int VALUE_TWO=99;
    public static final int VALUE_THREE=39;

    private final int i4=random.nextInt(20);
    static final int INT_5 = random.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);
    private final int[]a={1,2,3,4,5,6};

    @Override
    public String toString() {
        return "FinalData{" +
                "id='" + id + '\'' +
                ", i4=" + i4 +
                ", INT_5="+INT_5+
                '}';
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
//        fd1.v2++;
//        fd1.VAL_3=new Value(1);
//        fd1.a=new int[3];
        fd1.v1=new Value(9);
        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++;
        }
        System.out.println(fd1);
        FinalData fd2 = new FinalData("fd2");
        System.out.println(fd1);
        System.out.println(fd2);
    }
}

class Value {
    int i;

    public Value(int i) {
        this.i = i;
    }
}