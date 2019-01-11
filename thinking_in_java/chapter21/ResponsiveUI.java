package thinking_in_java.chapter21;

import java.io.IOException;

/**
 * Created by wangbin10 on 2019/1/11.
 */
public class ResponsiveUI extends Thread{
    private static volatile double d=1;

    public ResponsiveUI() {
//        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true) {
            d=d+(Math.PI+Math.E)/d;
        }
    }

    public static void main(String[] args) throws IOException {
        new ResponsiveUI();
        int read = System.in.read();
        System.out.println(read);
    }
}

class UnresponsiveUI {
    private static double d=1;

    public UnresponsiveUI() throws IOException {
        while (d > 0) {
            d = d + (Math.PI + Math.E)/d;
        }
        int read = System.in.read();
        System.out.println(read);
    }
}
