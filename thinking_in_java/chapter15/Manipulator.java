package thinking_in_java.chapter15;

/**
 * Created by wangbin10 on 2019/1/28.
 * 不指定T的边界，obj就没有可以使用的f()方法
 */
public class Manipulator<T extends HasF> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f();
    }

    public static void main(String[] args) {
        Manipulator<HasF> hasFManipulator = new Manipulator<>(new HasF());
        hasFManipulator.manipulate();
    }
}
