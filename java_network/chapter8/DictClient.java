package java_network.chapter8;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by wangbin10 on 2019/1/23.
 */
public class DictClient {
    public static final String SERVER = "dict.org";
    public static final int PORT=2628;
    public static final int TIMEOUT=15000;

    public static void main(String[] args) throws SocketException {

        try (Socket socket = new Socket(SERVER, PORT) ) {
            socket.setSoTimeout(TIMEOUT);
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer = new BufferedWriter(writer);
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
            for (String word : args) {
                define(word, writer, reader);
            }
            writer.write("quit\r\n");
            writer.flush();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void define(String word, Writer writer, BufferedReader reader) throws IOException {
        for(String line=reader.readLine();line!=null;line=reader.readLine()) {
            System.out.println(line);
        }
    }
}
