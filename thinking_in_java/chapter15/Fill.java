package thinking_in_java.chapter15;

import thinking_in_java.chapter10.Contents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by wangbin10 on 2019/1/28.
 */
public class Fill {
    public static <T> void fill(Collection<T> collection, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                collection.add(classToken.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

class Contract {
    private static long counter;
    public final long id=counter++;

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                '}';
    }
}

class TitleTransfer extends Contract {
}

class FillTest {
    public static void main(String[] args) {
        List<Contract> contracts = new ArrayList<>();
        Fill.fill(contracts, Contract.class, 3);
        Fill.fill(contracts,TitleTransfer.class,2);
        for (Contract contract : contracts) {
            System.out.println(contract);
        }

        SimpleQueue<Contract> contracts1 = new SimpleQueue<>();
//        Fill.fill(contracts1,Contract.class,3);SimpleQueue不是一个Collection类型
    }
}
