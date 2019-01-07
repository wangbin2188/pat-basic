package core_technology2.chapter4;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by wangbin10 on 2019/1/7.
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("172.17.2.41", 80)) {
            InputStream inputStream = s.getInputStream();
            Scanner in = new Scanner(inputStream);
            while (in.hasNextLine()) {
                String line=in.nextLine();
                System.out.println(line);
            }
        }

    }
}
