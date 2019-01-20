package thinking_in_java.chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * abc+表示匹配ab,后面跟一个或多个c;
 * (abc)+表示匹配一个或多个abc字符串
 */
public class TestRegularExpression {
    public static void main(String[] args) {
        String s = "abcabcabc";
        String[] arg={"abc+","(abc)+"};


        for (String ar:arg) {
            System.out.println("============");
            System.out.println("input:"+s);
            System.out.println("regex:"+ar);
            Pattern p = Pattern.compile(ar);
            Matcher m = p.matcher(s);
            while (m.find()) {
                System.out.println("Match:"+m.group()+","+m.start());
            }
        }
    }
}
