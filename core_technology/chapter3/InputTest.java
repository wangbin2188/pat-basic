package chapter3;

import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("what's you name?");
        String name=scanner.nextLine();
        System.out.println("how old are you ?");
        int age=scanner.nextInt();
        System.out.println("hello,"+name+" next year you will be "+(age+1));
    }
}
