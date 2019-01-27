package thinking_in_java.chapter15;

import java.util.ArrayList;
import java.util.Random;

public class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkoutStands= new ArrayList<CheckoutStand>();
    private Office office=new Office();

    public Store(int nAsiles, int nShelves, int nProducts) {
        for (int i = 0; i < nAsiles; i++) {
            add(new Aisle(nShelves, nProducts));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Aisle a:this) {
            for (Shelf shelf : a) {
                for (Product product : shelf) {
                    sb.append(product);
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(3,4,3));
    }
}

class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public static Generator<Product> generator=new Generator<Product>() {
        private Random rand = new Random(47);
        @Override
        public Product next() {
            return new Product(rand.nextInt(1000), "test", rand.nextDouble() * 100 + 0.99);
        }
    };
}

class Shelf extends ArrayList<Product> {
    public Shelf(int nProducts) {
        Generators.fill(this, Product.generator, nProducts);
    }
}

class Aisle extends ArrayList<Shelf> {
    public Aisle(int nShelves, int nProducts) {
        for (int i = 0; i < nShelves; i++) {
            add(new Shelf(nProducts));
        }
    }
}

class CheckoutStand{}
class Office{}
