package thinking_in_java.chapter15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 两种方式生成对象1。静态方法；2。静态对象
 */
public class Customer {
    private static long counter=1;
    private final long id=counter++;

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }

    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }

    public static Generator<Customer> generator=new Generator<Customer>() {
        @Override
        public Customer next() {
            return new Customer();
        }
    };

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 4);
        Generators.fill(line, Customer.generator, 5);
        for (Customer customer : line) {
            System.out.println(customer);
        }
    }
}


