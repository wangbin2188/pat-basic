package thinking_in_java.chapter13;

/**
 * X?代表一个或零个
 * X*代表零个或多个
 * X+代表一个或多个
 * X{n}恰好n个
 * X{n,}至少n个
 * X{n,m}至少n次，不超过m次
 */
public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }
}
