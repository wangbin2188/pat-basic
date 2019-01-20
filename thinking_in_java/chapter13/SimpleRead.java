package thinking_in_java.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class SimpleRead {
   public static BufferedReader input= new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.618"));

    public static void main(String[] args) {
        try {
            System.out.println("what's your name?");
            String name=input.readLine();
            System.out.println("How old are you ?what is you favorite double");
            System.out.println("(input:<age> <double>)");
            String numbers=input.readLine();
            System.out.println(numbers);
            String[] numArray = numbers.split(" ");
            int age = Integer.parseInt(numArray[0]);
            double favorite = Double.parseDouble(numArray[1]);
            System.out.format("%s,%d,%f",name,age,favorite);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
