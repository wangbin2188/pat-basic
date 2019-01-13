package thinking_in_java.chapter9.interf;

import thinking_in_java.chapter8.Note;

public interface Instrument {
    int VALUE=5;
    void play(Note n);
    void adjust();
}
