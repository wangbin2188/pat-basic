package thinking_in_java.chapter10.parcel7;

import thinking_in_java.chapter10.Contents;

/**
 * Created by wangbin10 on 2019/1/15.
 * contents方法把返回值的生成与表示这个返回值的类的定义结合在一起
 * 这个类是匿名的，他没有名字
 */
public class Parcel7 {
    public Contents contents() {
        return new Contents() {
            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 parcel7 = new Parcel7();
        Contents contents = parcel7.contents();
    }
}

