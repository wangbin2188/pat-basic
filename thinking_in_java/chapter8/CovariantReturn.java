package thinking_in_java.chapter8;

/**
 * 子类覆盖父类方法，可以返回更具体的类型
 */
public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);

        m=new WheatMill();
        g=m.process();
        System.out.println(g);
    }
}


class Grain {
    @Override
    public String toString() {
        return "Grain{}";
    }
}

class Wheat extends Grain {
    @Override
    public String toString() {
        return "Wheat{}";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {
    @Override
    Wheat process() {
        return new Wheat();
    }
}