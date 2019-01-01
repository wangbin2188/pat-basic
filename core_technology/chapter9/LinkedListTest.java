package chapter9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a=new LinkedList<>();
        a.add("amy");
        a.add("bob1");
        a.add("erik");

        List<String> b=new LinkedList<>();
        b.add("bob");
        b.add("doug");
        b.add("franse");
        b.add("cola");

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();
        while (bIter.hasNext()) {
            if (aIter.hasNext()) {
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        System.out.println(a);
    }
}
