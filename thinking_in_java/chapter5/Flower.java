package thinking_in_java.chapter5;

/**
 * 除了构造方法外，this()不能用于其他位置
 */
public class Flower {
    int petalCount=0;
    String s = "initial value";

    Flower(int petals) {
        this.petalCount=petals;
        System.out.println("int ");
    }

    Flower(String ss) {
        this.s=ss;
        System.out.println("string ");
    }

    Flower(String s, int petals) {
        this(petals);
        this.s=s;
        System.out.println("string int");
    }

    Flower() {
        this("hi", 47);
        System.out.println("no args");
    }

    void printPetalCount() {
        System.out.println("petalCount="+petalCount+" s= "+s);
    }

    public static void main(String[] args) {
        Flower flower = new Flower();
        flower.printPetalCount();
    }
}
