package java_network.chapter3;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * Created by wangbin10 on 2019/1/21.
 */
public class GZipRunnable implements Runnable {
    private final File input;

    public GZipRunnable(File input) {
        this.input = input;
    }

    @Override
    public void run() {
        if (!input.getName().endsWith(".gz")) {
            File output = new File(input.getParent(), input.getName() + ".gz");
            if (!output.exists()) {
                try (InputStream in = new BufferedInputStream(new FileInputStream(input));
                     OutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(output)))) {
                    int b;
                    while ((b = in.read()) != -1) {
                        out.write(b);
                    }
                    out.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
