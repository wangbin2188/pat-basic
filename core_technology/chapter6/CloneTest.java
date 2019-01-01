package chapter6;

public class CloneTest {
    public static void main(String[] args) {
        Employee2 origin = new Employee2("john", 5000);
        origin.setHireDay(2000, 1, 1);
        try {
            Employee2 clone = origin.clone();
            clone.raiseSalary(10);
            clone.setHireDay(2001,12,31);
            System.out.println(origin);
            System.out.println(clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
