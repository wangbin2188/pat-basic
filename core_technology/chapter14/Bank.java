package core_technology.chapter14;

/**
 * Created by wangbin10 on 2019/1/4.
 */
public interface Bank {
     void transfer(int from, int to, double amount);
     double getTotalBalance();
     int size();
}
