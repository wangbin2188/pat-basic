package thinking_in_java.chapter15;

import java.util.Date;

/**
 * Created by wangbin10 on 2019/1/28.
 * 混型：一个类聚集了多个类的能力
 * 1.接口实现混型
 */
public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
        mixin1.set("test1");
        mixin2.set("test2");
        System.out.println(mixin1.getSerialNumber() + "," + mixin1.getStamp());
    }
}

interface TimeStamped {
    long getStamp();
}

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;

    TimeStampedImp() {
        this.timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {
    long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Basic {
    void set(String val);

    String get();
}

class BasicImp implements Basic {
    private String val;

    @Override
    public void set(String val) {
        this.val = val;
    }

    @Override
    public String get() {
        return val;
    }
}

/**
 * 使用代理模式实现了混型，必须在Mixin中重写所有的方法，如果使用更复杂的混型时，代码量将急剧增加。
 */
class Mixin extends BasicImp implements TimeStamped, SerialNumbered {
    private TimeStamped timeStamped = new TimeStampedImp();
    private SerialNumbered serialNumbered = new SerialNumberedImp();

    @Override
    public long getStamp() {
        return timeStamped.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumbered.getSerialNumber();
    }
}