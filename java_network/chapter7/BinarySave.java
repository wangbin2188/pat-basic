package java_network.chapter7;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by wangbin10 on 2019/1/21.
 * 从web网站下载二进制文件并保存到磁盘
 */
public class BinarySave {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                URL url = new URL(args[i]);
                saveBinaryFile(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void saveBinaryFile(URL u) throws IOException {
        URLConnection uc = u.openConnection();
        String contentType = uc.getContentType();
        int contentLength = uc.getContentLength();
        if (contentType.endsWith("text/") || contentLength == -1) {
            throw new IOException("this is not a binary file!");
        }
        try (InputStream raw = uc.getInputStream()) {
            InputStream in = new BufferedInputStream(raw);
            byte[] bytes = new byte[contentLength];
            int offset = 0;
            while (offset < contentLength) {
                int bytesRead = in.read(bytes, offset, bytes.length - offset);
                if (bytesRead == -1) {
                    break;
                }
                offset += bytesRead;
            }

            if (offset != contentLength) {
                throw new IOException("");
            }
            //从url获取原始文件名，并去掉文件名之前的路径信息
            String filename = u.getFile();
            filename = filename.substring(filename.lastIndexOf("/") + 1);
            //构造一个文件输出流，将byte数组写入文件
            try (OutputStream fout = new FileOutputStream(filename)) {
                fout.write(bytes);
                fout.flush();
            }
        }

    }
}
