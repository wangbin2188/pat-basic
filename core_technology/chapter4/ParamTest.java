package core_technology.chapter4;

/**
 * Created by wangbin10 on 2019/1/3.
 * @author wangbin10
 */
public class ParamTest {
    public static void main(String[] args) {
        double percent = 10;
        System.out.println(percent);
        tripleValue(percent);
        System.out.println(percent);

        Employee hary = new Employee("hary", 3000);
        System.out.println(hary.getSalary());
        tripleSalary(hary);
        System.out.println(hary.getSalary());

        Employee a = new Employee("alice", 1000);
        Employee b = new Employee("bob", 2000);
        System.out.println(a.getName() + "," + b.getName());
        swap(a, b);
        System.out.println(a.getName() + "," + b.getName());
    }

    /**
     * x是实际参数的一个拷贝，是方法中的局部变量，x的改变不影响原来的实际参数
     * @param x
     */
    public static void tripleValue(double x) {
        x = 3 * x;
        System.out.println("end method x=" + x);
    }

    /**
     * 通过e改变了e所引用的对象，e引用的还是同一个对象，但是对象的状态改变了
     * @param e
     * @see core_technology.chapter4.Employee#raiseSalary(int)
     */
    public static void tripleSalary(Employee e) {
        e.raiseSalary(200);
        System.out.println("end method salary=" + e.getSalary());
    }

    /**
     * x,y的确交换了，但方法结束的时候，x,y的生命周期也结束了，并没有改变a,b的值
     * @param x
     * @param y
     */
    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("end method x=" + x.getName());
        System.out.println("end method y=" + y.getName());
    }


}
