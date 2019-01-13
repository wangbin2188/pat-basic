package thinking_in_java.chapter9.interf;

import java.util.Arrays;

/**
 * 如果processor是一个类，那么只有它的子类才能用于Apply.process(),降低了代码的复用性
 * processor作为一个接口将具有更好的灵活性
 * 任何实现了processor接口的类都能用于Apply.process()
 */
public abstract class StringProcessor implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    public abstract String process(Object input);

    public static String s = "Disagreement with beliefs is by definition incorrect";

    public static void main(String[] args) {
        Apply.process(new UpCase(), s);
        Apply.process(new DownCase(), s);
        Apply.process(new Splitter(), s);

    }
}

class UpCase extends StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }

}

class DownCase extends StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends StringProcessor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}