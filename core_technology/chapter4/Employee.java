package core_technology.chapter4;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Random;

/**
 * 类加载时就会进行静态变量的初始化，静态初始化块按顺序执行
 * 类加载完就可以执行main方法
 * 调用构造方法的具体过程：
 * 1.所有实例变量被初始化为默认值
 * 2.按照在类中出现的顺序，执行所有实例变量初始化语句和初始化块
 * 3.如果构造方法调用了另外一个构造方法，则执行另一个构造方法
 * 4.执行本构造方法
 * Created by wangbin10 on 2019/1/3.
 */
public class Employee {
    private int id;
    private String name;
    private double salary;
    private Date hireDay;
    private static int nextId = 1;

    /**
     * 类加载时执行一次
     */
    static{
        Random random = new Random();
        nextId=random.nextInt(10000);
    }

    /**
     * 每次创建对象都执行一次
     */
    {
        id=nextId;
        nextId++;
    }

    public Employee(){
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar();
        this.hireDay = calendar.getTime();
    }


    public Employee(String name, double salary, int year, int month, int day) {
        this(name, salary);
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.hireDay = calendar.getTime();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public double getSalary() {
        return salary;

    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        return (Date) hireDay.clone();
    }

    public void raiseSalary(int byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", salary=" + getSalary() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(hireDay, employee.hireDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("bob", 100, 1912, 1, 30);
        staff[1] = new Employee("alice", 200);
        staff[2]=new Employee();
        for (Employee employee : staff) {
            System.out.println(employee);
        }
    }
}
