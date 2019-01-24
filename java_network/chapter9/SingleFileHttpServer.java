package java_network.chapter9;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wangbin10 on 2019/1/24.
 * 构造每次只发送一个文件的服务器
 */
public class SingleFileHttpServer {
    private static final Logger logger=Logger.getLogger("SingleFileHttpServer");
    private final byte[] content;
    private final byte[] header;
    private final int port;
    private final String encoding;

    public static void main(String[] args) {
        try {
            Path path = Paths.get(args[0]);
            byte[] data = Files.readAllBytes(path);
            String contentType = URLConnection.getFileNameMap().getContentTypeFor(args[0]);
            SingleFileHttpServer httpServer = new SingleFileHttpServer(data, "UTF-8", contentType, 80);
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SingleFileHttpServer(byte[] data, String encoding, String mimeType, int port) {
        this.content = data;
        this.port = port;
        this.encoding = encoding;
        String header = "HTTP/1.0 200 OK \r\n"+"content-type"+mimeType+" charset="+encoding;
        this.header = header.getBytes(Charset.forName("US-ASCII"));
    }

    public SingleFileHttpServer(String data, String encoding,String mimeType,int port) throws UnsupportedEncodingException {
        this(data.getBytes(encoding), encoding, mimeType, port);
    }

    public void start(){
        ExecutorService pool = Executors.newFixedThreadPool(100);
        try (ServerSocket socket = new ServerSocket(this.port)) {
            logger.info("accept connection on port " + this.port);
            logger.info(new String(this.content, encoding));
            while (true) {
                try {
                    Socket connection = socket.accept();
                    HttpHandler handler = new HttpHandler(connection);
                    pool.submit(handler);
                } catch (IOException e) {
                    logger.log(Level.WARNING, "Exception accept connection" + e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class HttpHandler implements Callable<Void> {
        private final Socket connection;

        public HttpHandler(Socket connection) {
            this.connection = connection;
        }

        @Override
        public Void call() throws Exception {
            try {
                BufferedOutputStream out = new BufferedOutputStream(connection.getOutputStream());
                BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
                StringBuilder request = new StringBuilder(80);
                while (true) {
                    int c=in.read();
                    if (c == '\r' || c == '\n') {
                        break;
                    }
                    request.append(((char) c));
                }
                out.write(content);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                connection.close();
            }
            return null;
        }
    }

}
