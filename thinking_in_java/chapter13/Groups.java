package thinking_in_java.chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (A)((B)(C))
 * group(0)=ABC
 * group(1)=A
 * group(2)=BC
 * group(3)=B
 * group(4)=C
 *
 * find()可以在输入的任意位置定位正则表达式，
 * 而lookingAt()和matches()只有在正则表达式与输入的最开始处就开始匹配才能成功。
 * matches()只有在整个输入都匹配正则表达式时才会成功
 * 而lookingAt()只要输入的第一部分匹配就会成功
 */
public class Groups {
    public static final String POEM =
            "Twas briling, and the slithy toves\n" +
            "Did gyre and gimble in the wabe\n" +
            "All mimsy were the borogoes,\n" +
            "And the mome raths outgrabe.\n" +
            "Beware the jabberwock,my son,\n";

    public static void main(String[] args) {
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
        while (m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.print("("+i+")["+m.group(i)+"] ");
            }
            System.out.println();
        }
    }
}
