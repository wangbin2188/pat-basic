package java_network.chapter8;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by wangbin10 on 2019/1/23.
 * 查看1~1024哪个端口安装又tcp服务器
 */
public class LowPorterScanner {
    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "localhost";
        for (int i = 1; i < 1024; i++) {
            try (Socket socket = new Socket(host, i)) {
                System.out.println("there is a port on " + i);
            } catch (UnknownHostException e) {
                System.err.println(e);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
