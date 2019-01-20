package thinking_in_java.chapter13;

import java.util.Arrays;

/**
 * \W非单词字符
 * \w单词字符
 */
public class Splitting {
    public static String knights = "then when you have found the shrubbery,you must ...cut down the tree";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");
    }
}
