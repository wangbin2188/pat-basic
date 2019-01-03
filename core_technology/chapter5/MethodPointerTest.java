package core_technology.chapter5;

import java.lang.reflect.Method;

/**
 * Created by wangbin10 on 2019/1/3.
 * 反射机制调用任意方法
 */
public class MethodPointerTest {
    public static void main(String[] args) {
        try {
            Method square = MethodPointerTest.class.getMethod("square", double.class);
            Method sqrt = Math.class.getMethod("sqrt", double.class);
            printTable(1, 10, 10, square);
            printTable(1,10,10,sqrt);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public static double square(double x) {
        return x * x;
    }

    public static void printTable(double from, double to, int n, Method m) {
        System.out.println(m);
        double dx = (to - from) / (n - 1);
        for(double x=from;x<=to;x+=dx) {
            try {
                //静态方法不需要对象
                double y =(Double) m.invoke(null, x);
                System.out.printf("%8.2f,%8.2f",x,y);

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
