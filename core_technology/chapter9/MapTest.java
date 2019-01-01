package chapter9;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> staff = new HashMap<>();
        staff.put("144-25-5464", "amy lee");
        staff.put("567-24-2546", "harry hacker");
        staff.put("157-62-7935", "Gary cooper");
        staff.put("456-62-5527", "france corz");

        System.out.println(staff);
        staff.forEach((k,v)-> System.out.println("key="+k+";v="+v));
    }
}
