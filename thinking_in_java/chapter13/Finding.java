package thinking_in_java.chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finding {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher("evening is full of the linnet's wings");
        while (m.find()) {
            System.out.print(m.group()+" ");
        }

        System.out.println();
        int i=0;
        while (m.find(i)) {
            System.out.print(m.group()+" ");
            i++;
        }
    }
}
