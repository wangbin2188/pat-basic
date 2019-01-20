package thinking_in_java.chapter13;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * 除了能够扫描基本类型，还可以使用自定义的正则表达式进行扫描
 * 每次仅针对下一个输入分词进行匹配
 */
public class ThreatAnalyzer {
    static String threatData=
            "58.27.82.161@02/10/2005\n"+
            "58.27.82.161@02/10/2005\n"+
            "58.27.82.161@02/10/2005\n"+
            "58.27.82.161@02/10/2005\n"+
            "58.27.82.161@02/10/2005\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(threatData);
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@(\\d{2}/\\d{2}/\\d{4})";
        while (scanner.hasNext(pattern)) {
            scanner.next(pattern);
            MatchResult m = scanner.match();
            String ip = m.group(1);
            String date=m.group(2);
            System.out.println(ip+","+date);
        }
    }
}
