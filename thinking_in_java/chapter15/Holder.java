package thinking_in_java.chapter15;

import java.util.List;
import java.util.Objects;

/**
 * Created by wangbin10 on 2019/1/28.
 */
public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Holder<?> holder = (Holder<?>) o;
        return Objects.equals(value, holder.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);
//        Holder<Fruit> fruit=apple;
        Holder<? extends Fruit> fruit=apple;//这个可以，上面那一行不行
        Fruit fruit1 = fruit.get();

    }

    /**
     * apples是Apple的某个父类的list,因此可以持有Apple及其子类，这个没有问题；
     * 但是是否能持有Fruit是不确定的，因此编译报错了
     * @param apples
     */
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
//        apples.add(new Fruit()); 这个不行
    }
}
