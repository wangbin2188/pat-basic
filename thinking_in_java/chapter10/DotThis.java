package thinking_in_java.chapter10;

/**
 * Created by wangbin10 on 2019/1/14.
 * 如果在内部类内部需要生成外部类的引用，可以使用OutClassName.this的方式
 * 如果想要创建某个内部类的对象，可以使用外部类对象.new InnerClassName()的方式
 */
public class DotThis {

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        Inner inner = dotThis.new Inner();
        inner.outer().f();
    }
    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
    }

//    public Inner inner() {
//        return new Inner();
//    }
}
