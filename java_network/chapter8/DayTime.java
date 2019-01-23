package java_network.chapter8;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangbin10 on 2019/1/23.
 */
public class DayTime {
    public static void main(String[] args) {

    }

    public Date getDateFromNetWork() throws ParseException, IOException {
        try (Socket socket = new Socket("time.nist.com", 13)) {
            socket.setSoTimeout(15000);
            InputStream inputStream = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            Reader reader = new InputStreamReader(inputStream, "ASCII");
            for (int c = reader.read(); c != -1; c = reader.read()) {
                time.append(((char) c));
            }
            return parseDate(time.toString());
        }
    }

    private Date parseDate(String string) throws ParseException {
        String[] split = string.split(" ");
        String dateTime = split[1] + " " + split[2] + " UTC";
        DateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss z");
        return format.parse(dateTime);
    }
}
