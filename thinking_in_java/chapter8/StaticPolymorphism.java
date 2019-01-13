package thinking_in_java.chapter8;

/**
 * 静态方法是与类而非方法关联的，因此静态方法不具有多态性
 */
public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub();
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());
    }
}

class StaticSuper {
    public static String staticGet() {
        return "base staticGet()";
    }

    public String dynamicGet() {
        return "base dynamicGet()";
    }
}


class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "sub staticGet()";
    }

    public String dynamicGet() {
        return "sub dynamicGet()";
    }
}
