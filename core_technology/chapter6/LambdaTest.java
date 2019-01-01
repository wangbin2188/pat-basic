package chapter6;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

public class LambdaTest {
    public static void main(String[] args) {
        String[] planes = new String[]{"a", "bb","fbbbb", "cbbfsfsa", "bd"};
        System.out.println(Arrays.toString(planes));
        Arrays.sort(planes);
        System.out.println(Arrays.toString(planes));
        Arrays.sort(planes, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planes));
        Timer t = new Timer(1000, event -> System.out.println(new Date()));
        t.start();
        JOptionPane.showMessageDialog(null, "quit?");
        System.exit(0);
    }
}
