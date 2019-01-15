package thinking_in_java.chapter10.parcel4;

import thinking_in_java.chapter10.Contents;
import thinking_in_java.chapter10.Destination;

/**
 * Created by wangbin10 on 2019/1/15.
 * private 内部类对外界完全隐藏了实现细节
 */
public class TestParcel {
    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4();
        Contents contents = parcel4.contents();
        Destination des = parcel4.destination("des");
//        parcel4.new PContents();不能访问私有类
    }}

class Parcel4 {
    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    private class PDestination implements Destination {
        private String label;

        public PDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }
}

