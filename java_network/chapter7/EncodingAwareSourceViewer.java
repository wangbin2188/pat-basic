package java_network.chapter7;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by wangbin10 on 2019/1/21.
 * 用正确的字符集下载一个页面
 */
public class EncodingAwareSourceViewer {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                String encoding = "ISO-8859-1";
                URL url = new URL(args[i]);
                URLConnection uc = url.openConnection();
                String contentType = uc.getContentType();
                int encodingStart = contentType.indexOf("charset=");
                if (encodingStart != -1) {
                    encoding = contentType.substring(encodingStart + 8);
                }
                InputStream in = new BufferedInputStream(uc.getInputStream());
                Reader reader = new InputStreamReader(in, encoding);
                int c;
                while ((c = reader.read()) != -1) {
                    System.out.print(((char) c));
                }
                reader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
