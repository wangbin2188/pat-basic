package thinking_in_java.chapter10.parcel10;

import thinking_in_java.chapter10.Destination;

/**
 * Created by wangbin10 on 2019/1/15.
 * destination的参数必须是final的，因为他们在匿名内部类的内部使用
 */
public class Parcel10 {
    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;

            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("over");
                }
            }

            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }
}

