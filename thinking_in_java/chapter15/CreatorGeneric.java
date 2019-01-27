package thinking_in_java.chapter15;

/**
 * 显式的工厂方法
 */
public class CreatorGeneric {
    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.f();
    }
}

abstract class GenericWithCreate<T> {
    final T element;

    public GenericWithCreate() {
        this.element = create();
    }

    abstract T create();
}

class Item {

}

class Creator extends GenericWithCreate<Item> {


    @Override
    Item create() {
        return new Item();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}