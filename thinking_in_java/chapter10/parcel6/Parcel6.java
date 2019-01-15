package thinking_in_java.chapter10.parcel6;

/**
 * Created by wangbin10 on 2019/1/15.
 * if语句大括号之内的内部类，无法在大括号之外使用
 */
public class Parcel6 {
    private void internalTracking(boolean b) {
        if (b) {
            class TrackSlip {
                private String id;

                public TrackSlip(String id) {
                    this.id = id;
                }

                public String getSlip() {
                    return id;
                }
            }
            TrackSlip slip = new TrackSlip("id");
            String s = slip.getSlip();
        }
//        TrackSlip slip = new TrackSlip("id");超出了使用范围
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        parcel6.track();
    }}
