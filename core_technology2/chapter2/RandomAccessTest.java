package core_technology2.chapter2;

import core_technology.chapter4.Employee;

import java.io.*;

public class RandomAccessTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("carl cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("harry cracker", 50000, 1989, 12, 15);
        staff[2] = new Employee("tony cracker", 75000, 1990, 12, 15);

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"))) {
            for(Employee e:staff){
                writeData(out,e);
            }

        }


        try (RandomAccessFile in = new RandomAccessFile("employee.dat","r")) {
        }
    }

    private static void writeData(DataOutputStream out, Employee e) {

    }
}
