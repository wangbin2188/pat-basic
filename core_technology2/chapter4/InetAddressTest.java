package core_technology2.chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by wangbin10 on 2019/1/7.
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        if (args.length > 0) {
            String host = args[0];
            InetAddress[] allByName = InetAddress.getAllByName(host);
            for (InetAddress address : allByName) {
                System.out.println(address);
            }
        }else{
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
        }
    }
}
