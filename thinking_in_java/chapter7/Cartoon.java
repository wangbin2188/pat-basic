package thinking_in_java.chapter7;

/**
 * 子类构造方法执行之前必会调用父类的构造方法，构造一个父类的对象
 */
public class Cartoon extends Drawing{
    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();

    }

    public Cartoon() {
        System.out.println("Cartoon constructor");
    }
}

class Art {
    public Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    public Drawing() {
        System.out.println("Drawing constructor");
    }
}