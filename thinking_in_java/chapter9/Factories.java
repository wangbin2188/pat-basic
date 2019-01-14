package thinking_in_java.chapter9;

/**
 * Created by wangbin10 on 2019/1/14.
 * 工厂方法设计模式——使用工厂和创建工厂完全分离
 */
public class Factories {
    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());
        serviceConsumer(new Implementation2Factory());
    }

    public static void serviceConsumer(ServiceFactory fact) {
        Service service = fact.getService();
        service.method1();
        service.method2();
    }
}

interface Service {
    void method1();
    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {
    @Override
    public void method1() {
        System.out.println("implementation1 method1");
    }

    @Override
    public void method2() {
        System.out.println("implementation1 method2");
    }
}

class Implementation1Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implementation1();
    }
}

class Implementation2 implements Service {
    @Override
    public void method1() {
        System.out.println("implementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("implementation2 method2");
    }
}

class Implementation2Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implementation2();
    }
}