package thinking_in_java.chapter9;

import thinking_in_java.chapter8.Note;

public class Music4 {

    static void tune(Instrument instrument) {
        instrument.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] instruments) {
        for (Instrument instrument : instruments) {
            tune(instrument);
        }
    }

    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new WoodWind()
        };
        tuneAll(orchestra);

    }
}


abstract class Instrument {
    private int i;

    public abstract void play(Note n);

    public String what() {
        return "instrument";
    }

    public abstract void adjust();
}

class Wind extends Instrument{
    @Override
    public void play(Note n) {
        System.out.println("wind.play() "+n);
    }

    @Override
    public void adjust() {

    }

    public String what() {
        return "wind";
    }
}

class Percussion extends Instrument{
    @Override
    public void play(Note n) {
        System.out.println("percussion.play() " + n);
    }

    @Override
    public void adjust() {

    }

    public String what() {
        return "percussion";
    }
}

class Stringed extends Instrument{
    @Override
    public void play(Note n) {
        System.out.println("stringed.play() " + n);
    }

    @Override
    public void adjust() {

    }

    public String what() {
        return "stringed";
    }
}

class Brass extends Wind {
    @Override
    public void play(Note n) {
        System.out.println("brass.play() " + n);
    }

    @Override
    public void adjust() {
        System.out.println("brass.adjust()");
    }
}

class WoodWind extends Wind {
    @Override
    public void play(Note n) {
        System.out.println("woodwind.play() " + n);
    }

    @Override
    public String what() {
        return "woodwind";
    }
}
