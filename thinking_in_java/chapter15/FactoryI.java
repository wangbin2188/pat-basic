package thinking_in_java.chapter15;

public interface FactoryI<T> {
    T create();

    public static void main(String[] args) {
        FactoryI factory = new IntegerFactory();
        new Foo2<Integer>(factory);
        Widget.Factory factory1 = new Widget.Factory();
        new Foo2<Widget>(factory1);
    }
}

class Foo2<T> {
    private T x;

    public <F extends FactoryI<T>> Foo2(F factory) {
        this.x = factory.create();
    }
}

class IntegerFactory implements FactoryI<Integer> {
    @Override
    public Integer create() {
        return new Integer(0);
    }
}

class Widget{
    public static class Factory implements FactoryI<Widget> {
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}