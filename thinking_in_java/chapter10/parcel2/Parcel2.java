package thinking_in_java.chapter10.parcel2;

/**
 * Created by wangbin10 on 2019/1/14.
 * 如果想从外部类的非静态方法之外的任意位置创建某个内部类的对象，
 * 则必须指明这个内部类的类型OuterClassName.InnerClassName
 */
public class Parcel2 {
    public void ship(String dest1) {
        Content content = content();
        Destination dest = destination(dest1);
        System.out.println(dest.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 parcel2 = new Parcel2();
        parcel2.ship("task");
        Parcel2 q = new Parcel2();
        //创建直接执行内部类的引用
        Parcel2.Content content = q.content();
        Parcel2.Destination tas = q.destination("tas");
    }

    public Content content() {
        return new Content();
    }

    public Destination destination(String s) {
        return new Destination(s);
    }

    class Content {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        String readLabel() {
            return label;
        }
    }
}

class Test {
    public static void main(String[] args) {
        Parcel2 q = new Parcel2();
        Parcel2.Content content = q.content();
    }
}
