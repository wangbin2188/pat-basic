package thinking_in_java.chapter13;

import java.io.PrintStream;
import java.util.Formatter;

public class Turtle {
    private String name;
    private Formatter f;

    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public void move(int x, int y) {
        f.format("%s the turtle is at (%d,%d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream out = System.out;
        Turtle tommy = new Turtle("tommy", new Formatter(out));
        tommy.move(3, 4);
    }
}
