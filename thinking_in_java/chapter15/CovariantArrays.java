package thinking_in_java.chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangbin10 on 2019/1/28.
 * 将错误类型的对象放入数组就会触发ArrayStoreException
 */
public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0]=new Apple();
        fruits[1]=new Jonathan();
        try {
            fruits[2]=new Fruit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            fruits[3]=new Orange();
        } catch (Exception e) {
            e.printStackTrace();
        }
//不兼容的类型
//        ArrayList<Fruit> apples = new ArrayList<Apple>();

        List<? extends Fruit> flist = new ArrayList<Apple>();
//        无法编译，什么对象也放不进去
//        flist.add(new Apple());
//        flist.add(new Fruit());
//        flist.add(new Object());
        Apple fruit = (Apple) flist.get(0);

    }
}

class Fruit {

}

class Apple extends Fruit {

}

class Jonathan extends Apple {
}

class Orange extends Fruit {

}