package core_technology.chapter14;

/**
 * Created by wangbin10 on 2019/1/4.
 * 坏银行的账户总额会变化，人民不会把钱存到里面
 * 好银行的交易方法加了锁，它是线程安全的;
 * 当然也可以在transfer方法前加synchronize关键字,效果是一样的
 */
public class UnsynchBankTest {
    public static final int NACCOUNTS=100;
    public static final double INIT_BALANCE=1000;

    public static void main(String[] args) {
        Bank bank = new BadBank(NACCOUNTS, INIT_BALANCE);
        int i;
        for(i=0;i<NACCOUNTS;i++) {
            TransferRunnable r = new TransferRunnable(bank, i, INIT_BALANCE);
            Thread t=new Thread(r);
            t.start();
        }
    }
}
