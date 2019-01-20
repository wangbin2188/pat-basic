package thinking_in_java.chapter13;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * split(,3)可以限制将输入分割成字符串的数量
 */
public class SplitDemo {
    public static void main(String[] args) {
        String input = "This!!is use!!of!!points";
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input)));
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input,3)));
    }
}
