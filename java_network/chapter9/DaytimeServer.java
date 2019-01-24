package java_network.chapter9;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by wangbin10 on 2019/1/24.
 * 单线程Daytime服务器
 */
public class DaytimeServer {
    public static final int PORT = 13;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try (Socket connection = serverSocket.accept()) {
                    Writer writer = new OutputStreamWriter(connection.getOutputStream());
                    Date now=new Date();
                    writer.write(now.toString());
                    writer.write("\r\n");
                    writer.flush();
                    connection.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
