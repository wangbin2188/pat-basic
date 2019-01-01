package chapter3;

import java.util.Scanner;

public class Retirement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("how much money will you retire?");
        double goal=scanner.nextDouble();
        System.out.println("how much money will you get every year?");
        double pay=scanner.nextDouble();
        System.out.println("what is the interest rate?");
        double rate=scanner.nextDouble();

        int years=0;
        double balance=0;
        while (balance < goal) {
            balance=balance+pay;
            double interest=balance*rate/100;
            balance=balance+interest;
            years++;
        }
        System.out.println("you can retire in "+years+" years");
    }
}
