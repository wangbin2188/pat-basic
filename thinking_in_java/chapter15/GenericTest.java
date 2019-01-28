package thinking_in_java.chapter15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangbin10 on 2018/9/18.
 * mySort2() list中的元素必须是实现了Comparable接口的类或者其子类
 * Java采取的是类型擦除的方法来实现泛型，并通过extends和super关键字来约束泛型的上界和下界。
 * extends关键字用于确定泛型的上界。<A extends B>表示类B或者其子类。
 * super关键字用于确定泛型的下界，<A super B>表示类B或者其父类，一直到Object。？则是一个通配符。
 * 因此，<T extends Comparable<? super T>>表示了上界为实现了Comparable接口的类，<? super T>则表示实现Comparable接口的类的子类也可以，从而确定下界
 */
public class GenericTest {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(25));
        animals.add(new Dog(34));
        mySort1(animals);//ok

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(18));
        dogs.add(new Dog(19));
        /**
         * 这个编译不能通过，因为T推断是Animal，得到的是Dog，Dog没有实现Comparable，所以不行
         * mySort1(dogs);
         * */

        mySort2(animals);//ok
        mySort2(dogs);//ok
    }

    /**
     * mySort1的类型参数是T extends Comparable<T>，他要求T必须实现Comparable
     * @param list
     * @param <T>
     */
    public static <T extends Comparable<T>> void mySort1(List<T> list) {
        Collections.sort(list);
        System.out.println("mySort1 Success!");
    }

    /**
     * list中的元素必须是实现了Comparable接口的类或者其子类
     * @param list
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void mySort2(List<T> list) {
        Collections.sort(list);
        System.out.println("mySort2 Success!");

    }
}

class Animal implements Comparable<Animal> {
    int age;

    public Animal(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Animal o) {
        return Integer.compare(this.age, o.age);
    }
}

/**
 * Dog根本不能implements Comparable<Dog>，因为这样就会实现两个相同的接口
 */
class Dog extends Animal {
    public Dog(int age) {
        super(age);
    }
}