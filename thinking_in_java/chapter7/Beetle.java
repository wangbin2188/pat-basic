package thinking_in_java.chapter7;

/**
 * 程序入口在main方法
 * 1。首先要加载main方法所在类，如果有父类，则先加载父类，则加载当前类，类加载的同时静态对象，静态语句块顺序执行
 * 2。执行main方法中的语句
 * 3。如果要创建对象，则要执行构造方法，但在构造方法执行之前，实例变量首先设为默认值(基本类型=0，引用类型=null)
 * 4。如果有父类构造方法，则先执行父类构造方法（此时父类实例变量已被初始化）
 * 5。父类构造方法完成后，当前类实例变量按次序初始化，然后执行当前类构造方法
 */
public class Beetle extends Insect {
    private int k = printInit("beetle.k initialized");

    public Beetle() {
        System.out.println("beetle constructor");
        System.out.println("k=" + k+" j=" + j);
    }
    private static int x2 = printInit("static beetle.x2 initialized");

    public static void main(String[] args) {
        System.out.println("beetle main");
        Beetle beetle = new Beetle();
    }
}

class Insect {
    private int i = 9;
    protected int j;

    public Insect() {
        System.out.println("insect constructor");
        System.out.println("i=" + i + " j=" + j);
        j = 39;
    }

    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

