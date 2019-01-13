package thinking_in_java.chapter5;

/**
 * 初始化的顺序：
 * 1。先静态对象（静态变量，静态语句块）类加载时执行，且只执行一次；
 * 2。非静态对象（成员变量，实例语句块）对象创建时执行，每次创建对象都执行；
 * 3。执行构造方法
 */
public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("create new cupboard");
        new CupBoard();
        System.out.println("create new cupboard2");
        new CupBoard();
        table.f2(1);
        cupBoard.f3(1);

    }

    static Table table=new Table();
    static CupBoard cupBoard=new CupBoard();
}

class Bowl {
    public Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }

    void f1(int marker) {
        System.out.println("f1("+marker+")");
    }
}

class Table {
    static Bowl bowl = new Bowl(1);

    public Table() {
        System.out.println("table");
        bowl2.f1(1);
    }

    void f2(int marker) {
        System.out.println("f2("+marker+")");
    }

    static Bowl bowl2 = new Bowl(2);
}

class CupBoard {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    public CupBoard() {
        System.out.println("cupboard");
        bowl4.f1(2);
    }

    void f3(int marker) {
        System.out.println("f3("+marker+")");
    }

    static Bowl bowl5 = new Bowl(5);
}