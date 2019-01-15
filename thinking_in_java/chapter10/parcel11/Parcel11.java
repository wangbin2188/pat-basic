package thinking_in_java.chapter10.parcel11;

import thinking_in_java.chapter10.Contents;
import thinking_in_java.chapter10.Destination;


/**
 * Created by wangbin10 on 2019/1/15.
 */
public class Parcel11 {
    private static class ParcelContents implements Contents {
        private int i;

        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {
        private String label;

        public ParcelDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }

        public static Destination destination(String s) {
            return new ParcelDestination(s);
        }

        public static Contents contents() {
            return new ParcelContents();
        }
    }
}
