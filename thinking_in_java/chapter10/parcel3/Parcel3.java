package thinking_in_java.chapter10.parcel3;

/**
 * Created by wangbin10 on 2019/1/15.
 * 想创建内部类的对象，不能直接使用外部类的名字，而是必须依赖外部类的对象
 */
public class Parcel3 {
    class Contents {
        private int i=11;
        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        public String  readLabel() {
            return label;
        }
    }


    public static void main(String[] args) {

        Parcel3 parcel3 = new Parcel3();
        Contents contents = parcel3.new Contents();
        Destination sd = parcel3.new Destination("sd");
    }

}
