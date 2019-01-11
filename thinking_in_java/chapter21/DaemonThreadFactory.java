package thinking_in_java.chapter21;

import java.util.concurrent.ThreadFactory;

/**
 * Created by wangbin10 on 2019/1/10.
 */
public class DaemonThreadFactory  implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
