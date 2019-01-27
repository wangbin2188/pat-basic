package thinking_in_java.chapter15;

public class BasicBounds {

}

interface HasColor {
    java.awt.Color getColor();
}
class Colored<T extends HasColor>{
    T item;

    public Colored(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    java.awt.Color color() {
        return item.getColor();
    }
}

class Dimension {
    public int x,y,z;
}