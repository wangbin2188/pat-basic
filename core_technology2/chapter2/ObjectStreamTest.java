package core_technology2.chapter2;

import core_technology.chapter4.Employee;
import core_technology.chapter5.Manager;

import java.io.*;

public class ObjectStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee harry = new Employee("harry hacker", 5000, 1989, 10, 1);
        Manager carl = new Manager("carl craker", 80000, 1987, 12, 15);
        Manager tony = new Manager("tony tester", 40000, 1990, 3, 15);

        Employee[] staff = new Employee[3];
        staff[0]=harry;
        staff[1]=carl;
        staff[2]=tony;

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
            out.writeObject(staff);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"))) {
            Employee[] newStaff=(Employee[]) in.readObject();
            newStaff[1].raiseSalary(10);
            for (Employee employee : newStaff) {
                System.out.println(employee);
            }
        }
    }
}
