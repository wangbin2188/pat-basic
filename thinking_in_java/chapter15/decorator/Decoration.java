package thinking_in_java.chapter15.decorator;

import java.util.Date;

/**
 * Created by wangbin10 on 2019/1/28.
 * 装饰器模式实现混型
 * 尽管可以添加多层，但最后一层才是真正的类型，因此只要最后一层的方法是可见的。
 */
public class Decoration {
    public static void main(String[] args) {
        TimeStamped t = new TimeStamped(new Basic());
        TimeStamped t1 = new TimeStamped(new SerialNumbered(new Basic()));
        t1.getTimeStamp();
//        t1.getSerialNumber();
        SerialNumbered s1 = new SerialNumbered(new Basic());
        SerialNumbered s2 = new SerialNumbered(new TimeStamped(new Basic()));
        s2.getSerialNumber();

    }
}

class Basic {
    private String value;

    void set(String val) {
        this.value = val;
    }

    String get() {
        return value;
    }
}

class Decorator extends Basic {
protected Basic basic;

    public Decorator(Basic basic) {
        this.basic = basic;
    }

    @Override
    public void set(String val) {
        basic.set(val);
    }

    @Override
    public String get() {
        return basic.get();
    }
}

class TimeStamped extends Decorator {
    private final long timeStamp;

    public TimeStamped(Basic basic) {
        super(basic);
        this.timeStamp=new Date().getTime();
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}

class SerialNumbered extends Decorator {
    private static long counter=1;
    private final long SerialNumber=counter++;

    public SerialNumbered(Basic basic) {
        super(basic);
    }

    public long getSerialNumber() {
        return SerialNumber;
    }
}