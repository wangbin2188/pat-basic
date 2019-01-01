package chapter6;

import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("harray", 35000);
        staff[1] = new Employee("carl", 75000);
        staff[2] = new Employee("tony", 38000);

        Arrays.sort(staff);
        for (Employee employee : staff) {
            System.out.println(employee.getName()+","+employee.getSalary());
        }
    }
}


