package java_network.chapter9;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wangbin10 on 2019/1/24.
 * 记录日志的Daytime服务器
 */
public class LoggingDaytimeServer {


    public static final int PORT = 13;
    private final static Logger adultLogger = Logger.getLogger("requests");
    private final static Logger errorLogger = Logger.getLogger("error");


    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(50);
        try (ServerSocket socket = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket connection = socket.accept();
                    Callable<Void> task = new DaytimeTask(connection);
                    pool.submit(task);
                } catch (IOException e) {
                    errorLogger.log(Level.SEVERE,"accept error",e);
                }
            }
        } catch (IOException e) {
            errorLogger.log(Level.SEVERE, "cannot start server", e);
        }
    }

    private static class DaytimeTask implements Callable<Void> {
        private Socket connection;

        public DaytimeTask(Socket connection) {
            this.connection = connection;
        }

        @Override
        public Void call() throws Exception {
            try {
                Writer out = new OutputStreamWriter(connection.getOutputStream());
                Date now = new Date();
                adultLogger.info(now+" "+connection.getRemoteSocketAddress());
                out.write(now.toString() + " \r\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
