package java_network.chapter3;

import javax.xml.bind.DatatypeConverter;

/**
 * Created by wangbin10 on 2019/1/21.
 * 通过使用join,main方法会在各个线程结束前等待，因此可以获取线程执行完成的结果
 */
public class JoinDigestUserInterface {
    public static void main(String[] args) {
        ReturnDigest[] returnDigests = new ReturnDigest[args.length];
        for (int i = 0; i < args.length; i++) {
            returnDigests[i] = new ReturnDigest(args[i]);
            returnDigests[i].start();
        }

        for (int i = 0; i < args.length; i++) {
            try {
                returnDigests[i].join();
                StringBuilder result = new StringBuilder(args[i]);
                result.append(": ");
                byte[] digest = returnDigests[i].getDigest();
                result.append(DatatypeConverter.printHexBinary(digest));
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
