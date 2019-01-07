package core_technology2.chapter4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by wangbin10 on 2019/1/7.
 */
public class ThreadedEchoServer {
    public static void main(String[] args) throws IOException {
        try {
            int i = 1;
            ServerSocket s = new ServerSocket(8189);
            while (true) {
                Socket incoming = s.accept();
                System.out.println("sp:"+i);
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class ThreadedEchoHandler implements Runnable {
    private Socket incoming;

    public ThreadedEchoHandler(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = incoming.getInputStream();
            OutputStream outputStream = incoming.getOutputStream();
            Scanner in = new Scanner(inputStream);
            PrintWriter out = new PrintWriter(outputStream, true);
            out.println("hello,print BYE exit");
            boolean done =false;
            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                out.println("echo:" + line);
                if (line.trim().equals("BYE")) {
                    done=true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                incoming.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
