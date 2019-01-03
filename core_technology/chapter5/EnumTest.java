package core_technology.chapter5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangbin10 on 2019/1/3.
 * 枚举类和它的缩写
 */
public class EnumTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a size:");
        String s = scanner.next().toUpperCase();
        //返回指定名字的枚举类的常量
        Size size = Enum.valueOf(Size.class, s);
        System.out.println(size);
        //返回缩写，可以定义更有意义的值
        System.out.println(size.getAbb());
        //返回下标，从0开始
        System.out.println(size.ordinal());

        Size[] values = Size.values();
        System.out.println(Arrays.toString(values));
    }

}

enum Size {
    //这就是枚举类Size的四个实例，因此比较枚举值用“==”
    //构造方法只在构造枚举常量的时候有用
    SMALL("S"), MEDIUM("M"), LARGE("L"),EXTRA_LARGE("XL");

    private String abbreviation;

    Size(String abb) {
        this.abbreviation = abb;
    }

    public String getAbb() {
        return abbreviation;
    }
}
