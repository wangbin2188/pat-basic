package thinking_in_java.chapter9;

import java.util.Arrays;

public class Apply {

    public static void process(Processor p, Object s) {
        System.out.println(p.name());
        System.out.println(p.process(s));
    }

    public static String s="Disagreement with beliefs is by definition incorrect";

    public static void main(String[] args) {
        process(new UpperCase(),s);
        process(new DownCase(),s);
        process(new Splitter(),s);
    }
}


class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }


}

class UpperCase extends Processor {
    @Override
    Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class DownCase extends Processor {
    @Override
    Object process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class Splitter extends Processor {
    @Override
    Object process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}