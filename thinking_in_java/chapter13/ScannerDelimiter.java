package thinking_in_java.chapter13;

import java.util.Scanner;

/**
 * \\s*代表任何空白字符
 */
public class ScannerDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("12, 24 ,78 , 99,42");
        scanner.useDelimiter("\\s*,\\s*");
        while (scanner.hasNextInt()) {
            System.out.println(scanner.nextInt());
        }
    }
}
