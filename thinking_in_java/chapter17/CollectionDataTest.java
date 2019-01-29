package thinking_in_java.chapter17;

import thinking_in_java.chapter16.CountingGenerator;

import java.util.LinkedHashSet;

/**
 * Created by wangbin10 on 2019/1/29.
 * CollectionData继承自ArrayList，所以自然也是Collection的子类；
 * 任何Collection的子类构造器都接受Collection作为初始化内容
 */
public class CollectionDataTest {
    public static void main(String[] args) {
        CollectionData<String> list = CollectionData.list(new CountingGenerator.String(5), 7);
        LinkedHashSet<Object> set = new LinkedHashSet<>(list);
        System.out.println(set);
    }
}
