package thinking_in_java.chapter8;

/**
 * 初始化的实际过程是：
 * 1。在其他任何事物发生之前，将分配给对象的存储空间初始化为二进制的0。
 * 2。调用父类的构造方法（调用被覆盖的draw方法），此时radius=0
 * 3。按照声明顺序调用成员的初始化方法
 * 编写构造方法的有效准则：
 * 用尽可能简单方法使对象进入政常状态，如果可以的话，尽量避免调用其他方法。
 */
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}

class Glyph {
    void draw() {
        System.out.println("glyph.draw()");
    }

    public Glyph() {
        System.out.println("glyph before draw");
        draw();
        System.out.println("glyph after draw");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    public RoundGlyph(int r) {
        this.radius = r;
        System.out.println("roundGlyph.RoundGlyph(),radius=" + r);
    }

    @Override
    void draw() {
        System.out.println("roundGlyph.draw(),radius=" + radius);
    }
}