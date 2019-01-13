package thinking_in_java.chapter8;

/**
 * tune方法参数类型是instrument，wind是instrument的子类，所以tune可以接受wind类型，不需要任何类型转换
 */
public class Music {
    public static void tune(Instrument instrument) {
        instrument.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);
    }
}
