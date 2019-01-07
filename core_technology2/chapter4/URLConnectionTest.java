package core_technology2.chapter4;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import sun.misc.BASE64Encoder;

/**
 * Created by wangbin10 on 2019/1/7.
 */
public class URLConnectionTest {
    public static void main(String[] args) {

        try {
            String urlName;
            if (args.length > 0) {
                urlName = args[0];
            } else {
                urlName = "https://www.baidu.com/";
            }

            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();
            if (args.length > 2) {
                String username = args[1];
                String password = args[2];
                String input = username + ":" + password;
                String encoding = new BASE64Encoder().encode(input.getBytes());
                connection.setRequestProperty("Authorization", "Basic " + encoding);
            }
            connection.connect();
            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                for (String value : entry.getValue()) {
                    System.out.println(key + ":" + value);
                }
            }

            System.out.println("===========================");
            System.out.println(connection.getContentType());
            System.out.println(connection.getContentLength());
            System.out.println(connection.getContentEncoding());
            System.out.println(connection.getDate());
            System.out.println(connection.getExpiration());
            System.out.println(connection.getLastModified());
            System.out.println("===========================");

            Scanner in = new Scanner(connection.getInputStream());
            for (int i = 1; i <= 10 && in.hasNextLine(); i++) {
                System.out.println(in.nextLine());
            }
            if (in.hasNextLine()) {
                System.out.println("...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


