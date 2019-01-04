package core_technology.chapter14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangbin10 on 2019/1/4.
 */
public class GoodBank implements Bank {

    private final double [] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    public GoodBank(int n, double initBalance) {
        this.accounts = new double[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i]=initBalance;
        }
        bankLock = new ReentrantLock();
        sufficientFunds=bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount) {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                sufficientFunds.await();
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.println("total balance=" + getTotalBalance());
            sufficientFunds.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {
        bankLock.lock();
        try {
            double sum=0;
            for (double account : accounts) {
                sum+=account;
            }
            return sum;
        } finally {
        bankLock.unlock();
        }
    }

    public int size(){
        return accounts.length;
    }
}
