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
public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket s=new ServerSocket(8189)) {
            try (Socket incoming = s.accept()) {
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();
                try (Scanner in = new Scanner(inputStream)) {
                    PrintWriter out = new PrintWriter(outputStream, true);
                    out.println("Hello,enter BYE to Exit");
                    boolean done=false;
                    while (!done && in.hasNextLine()) {
                        String line=in.nextLine();
                        out.println("echo:" + line);
                        if (line.trim().equals("BYE")) {
                            done=true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
