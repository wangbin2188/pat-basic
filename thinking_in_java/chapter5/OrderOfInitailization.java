package thinking_in_java.chapter5;

/**
 * 所有成员变量的初始化早于构造方法，不管是在什么位置
 */
public class OrderOfInitailization {
    public static void main(String[] args) {
        House house=new House();
        house.f();
    }
}

class Window {
    Window(int marker) {
        System.out.println("window marker="+marker);
    }
}

class House {
    Window w1 = new Window(1);

    public House() {
        System.out.println("house");
        w3 = new Window(33);
    }

    Window w2 = new Window(2);
    void f() {
        System.out.println("f");
    }

    Window w3 = new Window(3);
}
