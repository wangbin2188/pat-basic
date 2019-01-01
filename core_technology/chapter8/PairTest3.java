package chapter8;

public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo=new Manager("gus greedy",800000,2003,12,15);
        Manager cfo = new Manager("sid", 600000, 2003, 12, 15);
        Pair<Manager> managerPair = new Pair<>(ceo, cfo);
        printManager(managerPair);
        ceo.setSalary(100000);
        cfo.setSalary(50000);

        Manager[] managers = {ceo, cfo};
        Pair<Employee> result = new Pair<>();
        minmaxSalary(managers,result);
        System.out.println(result.getFirst().getName()+","+result.getSecond().getName());

    }

    private static void printManager(Pair<Manager> managerPair) {
        System.out.println(managerPair.getFirst()+","+managerPair.getSecond());
    }

    public static void minmaxSalary(Manager[] a, Pair<? super Manager> result) {
        if (a.length == 0) {
            return;
        }
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.getSalary() > a[i].getSalary()) {
                min = a[i];
            }
            if (max.getSalary() < a[i].getSalary()) {
                max = a[i];
            }
            result.setFirst(min);
            result.setSecond(max);
        }
    }

    public static void maxminSalary(Manager[] a, Pair<? super Manager> result) {
        minmaxSalary(a,result);
        PairAlg.swapHelper(result);
    }
}

class PairAlg{
    public static boolean hasNulls(Pair<?> pair) {
        return pair.getFirst()==null || pair.getSecond()==null;
    }

    public static void swap(Pair<?> pair) {
        swapHelper(pair);
    }

    public static <T> void swapHelper(Pair<T> pair) {
        T t =pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(t);
    }
}

class Employee{
    private String name;
    private Integer salary;
    private Integer year;
    private Integer month;
    private Integer day;

    public Employee(String name, Integer salary, Integer year, Integer month, Integer day) {
        this.name = name;
        this.salary = salary;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}

class Manager extends Employee{


    public Manager(String name, int salary, int year, int month, int day) {
        super(name,salary,year,month,day);
    }
}
