package java_network.chapter9;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by wangbin10 on 2019/1/24.
 */
public class LocalPortScanner {
    public static void main(String[] args) {
        for (int port = 1; port <= 65535; port++) {
            try {
                ServerSocket socket = new ServerSocket(port);
            } catch (IOException e) {
                System.out.println("there is a server on port "+port);
            }
        }
    }
}
