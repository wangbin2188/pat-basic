package thinking_in_java.chapter10.parcel8;

/**
 * Created by wangbin10 on 2019/1/15.
 * 匿名内部类的类型未必一定是接口，也可以是普通的类（被当做接口使用），内部类中重写了父类的方法
 */
public class Parcel8 {
    public Wrapping wrapping(int x) {
        return new Wrapping(x) {
            public int value(){
                return super.value()*47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        Wrapping wrapping = parcel8.wrapping(8);
    }}
