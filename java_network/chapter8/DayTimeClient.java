package java_network.chapter8;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;

/**
 * Created by wangbin10 on 2019/1/23.
 */
public class DayTimeClient {
    public static void main(String[] args) {
        String hostname = args.length > 0 ? args[0] : "time.nist.gov";
        Socket socket=null;
        try {
            socket= new Socket(hostname, 13);
            socket.setSoTimeout(15000);
            InputStream inputStream = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            Reader reader = new InputStreamReader(inputStream,"ASCII");
            for(int c=reader.read();c!=-1;c=reader.read()) {
                time.append(((char) c));
            }
            System.out.println(time);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
