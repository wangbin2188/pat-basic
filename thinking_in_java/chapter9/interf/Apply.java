package thinking_in_java.chapter9.interf;

public class Apply {
    public static void process(Processor p, Object s) {
        System.out.println(p.name());
        System.out.println(p.process(s));

    }
}
