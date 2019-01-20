package thinking_in_java.chapter13;

import java.util.Scanner;

/**
 * 默认情况下，Scanner根据空白字符对输入进行分词，当然也可以自定义分隔符
 */
public class BetterRead {
    public static void main(String[] args) {
        Scanner stdin=new Scanner(SimpleRead.input);
        System.out.println("what is your name?");
        String name=stdin.nextLine();
        System.out.println(name);
        System.out.println("how old are you ?what is your favorite double?");
        System.out.println("input:<age> <double>");
        int age=stdin.nextInt();
        double favorite=stdin.nextDouble();
        System.out.format("%s,%d,%f",name,age,favorite);
    }
}
