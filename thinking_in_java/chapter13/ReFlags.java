package thinking_in_java.chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MULTILINE 在多行模式下，^,$匹配一行的开始和结束
 * 默认情况下，^$匹配的式字符串的开始和结束
 */
public class ReFlags {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher("java has regex\nJava has regex\n" +
                "JAVA has pretty good regular expression in Java\n");
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
