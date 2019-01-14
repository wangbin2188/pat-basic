package thinking_in_java.chapter10;

/**
 * Created by wangbin10 on 2019/1/14.
 */
public class Parcel1 {
    public void ship(String dest1) {
        Content content = new Content();
        Destination dest = new Destination(dest1);
        System.out.println(dest.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 parcel1 = new Parcel1();
        parcel1.ship("dest");
    }

    class Content {
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

        String readLabel() {
            return label;
        }
    }

}
