package thinking_in_java.chapter15;

import java.lang.reflect.Method;
import java.util.*;

public class ContainerMethodDifferences {
    static Set<String> methodSet(Class<?> type) {
        TreeSet<String> result = new TreeSet<>();
        for (Method m : type.getMethods()) {
            result.add(m.getName());
        }
        return result;
    }

    static void interfaces(Class<?> type) {
        System.out.println("interfaces in "+type.getSimpleName()+" :");
        ArrayList<String> result = new ArrayList<>();
        for (Class<?> c : type.getInterfaces()) {
            result.add(c.getSimpleName());
        }
        System.out.println(result);
    }

    static Set<String> object = methodSet(Object.class);
    static {
        object.add("clone");
    }

    static void difference(Class<?> superset, Class<?> subset) {
        System.out.println(subset.getSimpleName() + " extends " + subset.getSimpleName() + " ,adds:");
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object);
        System.out.println("difference:"+comp);
        interfaces(superset);
    }

    public static void main(String[] args) {
        System.out.println("Collection:"+methodSet(Collection.class));
        interfaces(Collection.class);
        difference(Set.class,Collection.class);
        difference(HashSet.class,Set.class);
        difference(TreeSet.class,Set.class);
    }
}
