package thinking_in_java.chapter8;

/**
 * main方法（是静态方法，会在类加载时执行）为程序入口，先进行类加载，如果创建对象则：
 * 父类构造方法先执行；
 * 当前类成员变量按声明顺序初始化；
 * 当前类构造方法执行。
 */
public class Sandwich extends PortableLunch{
    private Bread b=new Bread();
    private Cheese c=new Cheese();
    private Lettuce l=new Lettuce();

    public Sandwich() {
        System.out.println("sandwich()");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}

class Meal {
    public Meal() {
        System.out.println("meal()");
    }
}

class Bread {
    public Bread() {
        System.out.println("bread()");
    }
}

class Cheese {
    public Cheese() {
        System.out.println("cheese()");
    }
}

class Lettuce {
    public Lettuce() {
        System.out.println("lettuce()");
    }
}

class Lunch extends Meal {
    public Lunch() {
        System.out.println("lunch()");
    }
}

class PortableLunch extends Lunch {
    public PortableLunch() {
        System.out.println("portableLunch()");
    }
}

