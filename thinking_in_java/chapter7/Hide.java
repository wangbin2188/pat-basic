package thinking_in_java.chapter7;

/**
 * page140
 */
public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
}

class Homer {
    char doh(char c) {
        System.out.println("doh(char)");
        return 'd';
    }

    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class Milhouse {

}

class Bart extends Homer {
    void doh(Milhouse m) {
        System.out.println("doh(milhouse)");
    }
}

class Lisa extends Homer {
    //不是真正的覆盖，编译就会出错
    //@Override
    void doh(Milhouse m) {
        System.out.println("doh(milhouse)");
    }
}