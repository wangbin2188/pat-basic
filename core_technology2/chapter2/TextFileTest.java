package core_technology2.chapter2;

import core_technology.chapter4.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Scanner;

public class TextFileTest {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("carl cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("harry cracker", 50000, 1989, 12, 15);
        staff[2] = new Employee("tony cracker", 75000, 1990, 12, 15);

        try (PrintWriter out = new PrintWriter("employee.dat", "UTF-8")) {
            writeData(staff, out);
        }

        try (Scanner in = new Scanner(new FileInputStream("employee.dat"), "UTF-8")) {
            Employee[] newStaff = readData(in);
        }
    }

    private static Employee[] readData(Scanner in) {
        int n=in.nextInt();
        in.nextLine();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i]=readEmployee(in);
        }
        return employees;
    }

    private static Employee readEmployee(Scanner in) {
        String line=in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        LocalDate hireDate = LocalDate.parse(tokens[2]);
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();
        return new Employee(name,salary,year,month,day);
    }

    private static void writeData(Employee[] staff, PrintWriter out) {
        out.println(staff.length);
        for (Employee employee : staff) {
            writeEmployee(out, employee);
        }
    }

    private static void writeEmployee(PrintWriter out, Employee employee) {
        out.println(employee.getName()+"|"+employee.getSalary()+"|"+employee.getHireDay());
    }


}
