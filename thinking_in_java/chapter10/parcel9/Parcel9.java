package thinking_in_java.chapter10.parcel9;

import thinking_in_java.chapter10.Destination;

/**
 * Created by wangbin10 on 2019/1/15.
 * 在匿名内部类中定义字段时，还可以对其进行初始化
 * 如果希望匿名内部类使用一个外部的对象，那么要求其是参数引用是final的
 * 在匿名类中不可能有具名构造方法，因为类是匿名的，但如果想进行一些构造方法的行为，可以使用实例代码块的方式
 */
public class Parcel9 {
    public Destination destination(final String dest) {
        return new Destination() {
            private String label=dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Destination ds = parcel9.destination("ds");
    }

}
