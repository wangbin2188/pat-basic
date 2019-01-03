package core_technology.chapter4;

/**
 * Created by wangbin10 on 2019/1/3.
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("harray", 35000,1987,12,15);
        staff[1] = new Employee("carl", 75000,1989,10,1);
        staff[2] = new Employee("tony", 38000,1990,3,15);

        for (Employee e : staff) {
            e.raiseSalary(5);
        }
        for (Employee e : staff) {
            System.out.println(e.toString());
        }
    }
}
