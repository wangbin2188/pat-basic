package core_technology.chapter5;

import core_technology.chapter4.Employee;

/**
 * Created by wangbin10 on 2019/1/3.
 */
public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("boss", 20000, 1970, 1, 1);
        boss.setBonus(10000);

        Employee[] staff = new Employee[3];
        staff[0]=boss;
        staff[1]=new Employee("bob", 100, 1912, 1, 30);
        staff[2] = new Employee("alice", 200);
        for (Employee employee : staff) {
            System.out.println(employee);
        }
    }
}
