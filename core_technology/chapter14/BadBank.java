package core_technology.chapter14;

/**
 * Created by wangbin10 on 2019/1/4.
 * 这个银行的交易是线程不安全的
 */
public class BadBank implements Bank {
    private final double [] accounts;
    public BadBank(int n, double initBalance) {
        this.accounts = new double[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i]=initBalance;
        }
    }

    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }
        System.out.println(Thread.currentThread());
        accounts[from]-=amount;
        System.out.printf("%10.2f from %d to %d", amount, from, to);
        accounts[to]+=amount;
        System.out.println("total balance="+getTotalBalance());
    }

    public double getTotalBalance() {
        double sum=0;
        for (double account : accounts) {
            sum+=account;
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }
}
