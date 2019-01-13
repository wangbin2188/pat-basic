package thinking_in_java.chapter5;

public class Overloading {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("tree" + i);
        }
        new Tree();
    }
}

class Tree {
    int height;

    public Tree() {
        System.out.println("planting a seedling");
        this.height=0;
    }

    public Tree(int height) {
        System.out.println("create new tree ,height="+height);
        this.height = height;
    }

    void info() {
        System.out.println("tree's height is "+this.height);
    }

    void info(String s) {
        System.out.println("tree's name is "+s+" height is "+this.height);
    }
}
