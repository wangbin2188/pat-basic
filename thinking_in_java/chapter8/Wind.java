package thinking_in_java.chapter8;

public class Wind extends Instrument{
    public void play(Note note) {
        System.out.println("wind play() "+note);
    }
}

class Instrument {
    public void play(Note note) {
        System.out.println("instrument play()");
    }
}
