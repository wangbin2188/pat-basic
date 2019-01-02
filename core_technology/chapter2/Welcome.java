package core_technology.chapter2;

/**
 * Created by wangbin10 on 2019/1/2.
 */
public class Welcome {
    public static void main(String[] args) {
        String[] greeting = new String[3];
        greeting[0] = "welcome to java";
        greeting[1] = "by gay";
        greeting[2] = "and cron";
        for (String s : greeting) {
            System.out.println(s);
        }
    }
}
