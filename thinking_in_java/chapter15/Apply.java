package thinking_in_java.chapter15;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Apply {
    public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args) {
        try {
            for (T t : seq) {
                f.invoke(t, args);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Shape {
    public void rotate() {
        System.out.println(this + " rotate");
    }

    public void resize(int newSize) {
        System.out.println("size:"+newSize);
    }
}

class Square extends Shape{}

class FilledList<T> extends ArrayList<T> {
    public FilledList(Class<? extends T> type,int size) {
        try {
            for (int i = 0; i < size; i++) {
                add(type.newInstance());
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


class ArrayTest {
    public static void main(String[] args) throws NoSuchMethodException {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shapes.add(new Shape());
        }
        Apply.apply(shapes,Shape.class.getMethod("rotate"));

        Apply.apply(shapes,Shape.class.getMethod("resize", int.class),5);

        ArrayList<Square> squares = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            squares.add(new Square());
        }

        Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);

        Apply.apply(new FilledList<Shape>(Shape.class,10),Shape.class.getMethod("rotate"));
        Apply.apply(new FilledList<Shape>(Square.class,10),Shape.class.getMethod("rotate"));
        
    }
}
