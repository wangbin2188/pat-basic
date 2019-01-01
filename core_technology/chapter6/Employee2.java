package chapter6;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee2 implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee2(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.hireDay = new Date();

    }

    public Employee2 clone() throws CloneNotSupportedException {
        Employee2 cloned = (Employee2) super.clone();
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }

    public void setHireDay(int year,int month,int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        this.hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise=salary*byPercent/100;
        salary+=raise;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
