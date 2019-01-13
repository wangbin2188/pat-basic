package thinking_in_java.chapter5;

public class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}

class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println("yummy");
    }

}

/**
 * peeler 削皮刀
 * @param
 * @Return
 */
class Peeler {
    static Apple peel(Apple apple) {
        return apple;
    }

}

/**
 * 削皮刀的参数就是apple，在Apple类内调用，apple对象=this
 */

class Apple {
    Apple getPeeled() {
        return Peeler.peel(this);
    }
}