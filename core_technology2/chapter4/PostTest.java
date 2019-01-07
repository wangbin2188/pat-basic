package core_technology2.chapter4;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by wangbin10 on 2019/1/7.
 */
public class PostTest {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get(args[0]))) {
            props.load(in);
        }
        String url=props.remove("url").toString();
        String result=doPost(url,props);
        System.out.println(result);
    }

    private static String doPost(String urlString, Map<Object,Object> nameValuePairs) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        /**
         * 默认情况下建立的链接只产生从服务器读取的输入流，并不产生任何写操作的输出流
         * 如果想获得输出流就必须setDoOutPut(true)
         */
        connection.setDoOutput(true);

        try (PrintWriter out = new PrintWriter(connection.getOutputStream())) {
            boolean first=true;
            for (Map.Entry<Object, Object> pair : nameValuePairs.entrySet()) {
                if (first) {
                    first = false;
                } else {
                    out.print("&");
                }
                String name=pair.getKey().toString();
                String value=pair.getValue().toString();
                out.print(name);
                out.print("=");
                out.print(URLEncoder.encode(value,"UTF-8"));
            }
        }

        StringBuilder response = new StringBuilder();
        try (Scanner in = new Scanner(connection.getInputStream())) {
            while (in.hasNextLine()) {
                response.append(in.nextLine());
                response.append("\n");
            }
        } catch (IOException e) {
            if (!(connection instanceof HttpURLConnection)) {
                throw e;
            }
            InputStream errorStream = ((HttpURLConnection) connection).getErrorStream();
            if (errorStream == null) {
                throw e;
            }
            Scanner in = new Scanner(errorStream);
            response.append(in.nextLine());
            response.append("\n");
        }

        return response.toString();
    }
}
