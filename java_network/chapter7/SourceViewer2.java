package java_network.chapter7;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by wangbin10 on 2019/1/21.
 * 用URLConnection下载一个web页面
 */
public class SourceViewer2 {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                URL url = new URL(args[0]);
                URLConnection uc = url.openConnection();
                try (InputStream raw = uc.getInputStream()) {
                    InputStream buffer = new BufferedInputStream(raw);
                    Reader reader = new InputStreamReader(buffer);
                    int c;
                    while ((c=reader.read()) != -1) {
                        System.out.print((char) c);

                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
