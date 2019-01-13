package thinking_in_java.chapter9.interf;

import thinking_in_java.chapter8.Note;

/**
 * 在子类中通过super.method()调用父类方法，如果父类方法中有this,那么在实际执行时this代表当前类——子类，而非父类
 */
public class Music5 {
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

class Wind implements Instrument {
    @Override
    public void play(Note n) {
        System.out.println(this.getClass().getSimpleName()+".play() "+n);
    }

    @Override
    public void adjust() {
        System.out.println(this.getClass().getSimpleName()+".adjust()");
    }
}

class Percussion implements Instrument {
    @Override
    public void play(Note n) {
        System.out.println(this.getClass().getSimpleName()+".play() "+n);
    }

    @Override
    public void adjust() {
        System.out.println(this.getClass().getSimpleName()+".adjust()");
    }
}

class Stringed implements Instrument {
    @Override
    public void play(Note n) {
        System.out.println(this.getClass().getSimpleName()+".play() "+n);
    }

    @Override
    public void adjust() {
        System.out.println(this.getClass().getSimpleName()+".adjust()");
    }
}

class Brass extends Wind {
    @Override
    public void play(Note n) {
        super.play(n);
    }

    @Override
    public void adjust() {
        super.adjust();
    }
}

class WoodWind extends Wind {
    @Override
    public void play(Note n) {
        super.play(n);
    }

    @Override
    public void adjust() {
        super.adjust();
    }
}