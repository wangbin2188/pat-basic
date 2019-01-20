package thinking_in_java.chapter13;

/**
 * replaceFirst替换第一个
 * replaceAll替换所有
 */
public class Replacing {
   static String s= Splitting.knights;

    public static void main(String[] args) {
        System.out.println(s.replaceFirst("f\\w+","locate"));
        System.out.println(s.replaceAll("tree|you","apple"));
    }
}
