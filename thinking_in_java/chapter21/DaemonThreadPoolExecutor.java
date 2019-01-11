package thinking_in_java.chapter21;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangbin10 on 2019/1/10.
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {

    public DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<>(),new DaemonThreadFactory());
    }
}
