package thinking_in_java.chapter15;

/**
 * Created by wangbin10 on 2019/1/28.
 * Solid2通过继承父类持有一个T item对象，并且要求这个对象满足T extends Dimension & HasColor & Weight
 * 对应的方法被继承过来，不用重复声明
 */
public class InheritBounds {
    public static void main(String[] args) {
        Solid2<Bounded> solid2=new Solid2<Bounded>(new Bounded());
        solid2.color();
        solid2.weight();
        solid2.getY();
    }
}

class HoldItem<T> {
    T item;

    public HoldItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

class Colored2<T extends HasColor> extends HoldItem<T> {

    public Colored2(T item) {
        super(item);
    }

    java.awt.Color color() {
        return item.getColor();
    }
}

class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T> {
    public ColoredDimension2(T item) {
        super(item);
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T> {
    public Solid2(T item) {
        super(item);
    }


    public int weight() {
        return item.weight();
    }
}