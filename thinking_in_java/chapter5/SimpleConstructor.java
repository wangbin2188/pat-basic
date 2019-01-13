package thinking_in_java.chapter5;

public class SimpleConstructor {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Rock2(i);
        }
    }

}

class Rock {
    public Rock() {
        System.out.println("Rock ");
    }
}

class Rock2 {
    public Rock2(int i) {
        System.out.println("Rock2"+i);
    }
}
