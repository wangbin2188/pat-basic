package thinking_in_java.chapter9.interf;
/**
 * 这种使用适配器的方式中，FilterAdapter的构造方法接受已经有的接口Filter,
 * 然后生产具有你所需要的Processor接口的对象
 * FilterAdapter中用到了代理
 */
public class FilterAdapter implements Processor {
    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }
}
