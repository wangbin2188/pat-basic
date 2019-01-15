package thinking_in_java.chapter10.parcel5;


import thinking_in_java.chapter10.Destination;

/**
 * Created by wangbin10 on 2019/1/15.
 * PDestination是方法destination的一部分，是局部类，在方法之外无法访问
 */
public class Parcel5 {
    public Destination destination(String s) {
        class PDestination implements Destination {
            private String label;

            public PDestination(String label) {
                this.label = label;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        Destination s = parcel5.destination("s");
    }
}


