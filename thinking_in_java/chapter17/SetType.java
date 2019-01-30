package thinking_in_java.chapter17;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by wangbin10 on 2019/1/30.
 */
public class SetType {
    int i;

    public SetType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetType setType = (SetType) o;
        return i == setType.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }

    @Override
    public String toString() {
        return "SetType{" +
                "i=" + i +
                '}';
    }
}

class HashType extends SetType {
    public HashType(int i) {
        super(i);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int i) {
        super(i);
    }

    @Override
    public int compareTo(TreeType o) {
        return Integer.compare(i,o.i);
    }
}

class TypesForSets {
    static <T> Set<T> fill(Set<T> set, Class<T> type)  {
        for (int i = 0; i < 10; i++) {
            try {
                Constructor<T> constructor = type.getConstructor(int.class);
                T t = constructor.newInstance(i);
                set.add(t);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    static <T> void test(Set<T> set, Class<T> type) {
        fill(set, type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        test(new LinkedHashSet<SetType>(), SetType.class);
        test(new LinkedHashSet<HashType>(), HashType.class);
        test(new LinkedHashSet<TreeType>(), TreeType.class);
    }
}