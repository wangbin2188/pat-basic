package java_network.chapter9;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by wangbin10 on 2019/1/24.
 * 多线程Daytime服务器
 */
public class MultiThreadDaytimeServer {
    public static final int PORT=37;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            Socket connection = server.accept();
            Thread task = new DaytimeThread(connection);
            task.start();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("can't start server");
        }
    }

    private static class DaytimeThread extends Thread {
        private Socket connection;

        public DaytimeThread(Socket connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            try {
                Writer out = new OutputStreamWriter(connection.getOutputStream());
                Date now=new Date();
                out.write(now.toString()+"\r\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
