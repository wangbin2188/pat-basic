package thinking_in_java.chapter7;

/**
 * final参数无法在方法内被修改
 * final方法无法被覆盖
 * final类无法被继承
 */
public class FinalArguments {
    void with(final Gizmo g) {
        //g=new Gizmo();
    }

    void without(Gizmo gizmo) {
        gizmo=new Gizmo();
        gizmo.spin();
    }

    void f(final int i) {
        //i++;
    }

    int g(final int i) {
        return i+1;
    }

    public static void main(String[] args) {
        FinalArguments fa = new FinalArguments();
        fa.with(null);
        fa.without(null);
    }


}

class Gizmo {
    public void spin() {

    }

}
