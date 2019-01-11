package thinking_in_java.chapter21;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangbin10 on 2019/1/10.
 */
public class Daemons {
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");
// Allow the daemon threads to
// finish their startup processes:
        TimeUnit.SECONDS.sleep(1);

    }
}
