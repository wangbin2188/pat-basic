package java_network.chapter3;

import java.io.*;
import java.util.Date;

/**
 * Created by wangbin10 on 2019/1/21.
 * writeEntry同步的三种方式：
 * 1.方法前加synchronized关键字；
 * 2.对当前对象进行同步，synchronized(this)；
 * 3.对out进行同步，synchronized(out)
 */
public class LogFile {
    private Writer out;

    public LogFile(File f) throws IOException {
        FileWriter fw = new FileWriter(f);
        this.out = new BufferedWriter(fw);
    }

    private synchronized void writeEntry(String message) throws IOException {
        Date d=new Date();
        out.write(d.toString());
        out.write("\t");
        out.write(message);
        out.write("\r\n");
    }

    private  void writeEntry2(String message) throws IOException {
        synchronized (this) {
            Date d=new Date();
            out.write(d.toString());
            out.write("\t");
            out.write(message);
            out.write("\r\n");
        }
    }

    private  void writeEntry3(String message) throws IOException {
        synchronized (this) {
            Date d=new Date();
            out.write(d.toString());
            out.write("\t");
            out.write(message);
            out.write("\r\n");
        }
    }

    public void close() throws IOException {
        out.flush();
        out.close();
    }
}
