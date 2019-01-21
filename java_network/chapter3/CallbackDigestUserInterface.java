package java_network.chapter3;

import javax.xml.bind.DatatypeConverter;

/**
 * Created by wangbin10 on 2019/1/21.
 */
public class CallbackDigestUserInterface {
    public static void receiveDigest(byte[] digest, String filename) {
        StringBuilder result = new StringBuilder(filename);
        result.append(":");
        result.append(DatatypeConverter.printHexBinary(digest));
        System.out.println(result);
    }

    public static void main(String[] args) {
        for (String filename : args) {
            CallbackDigest cb = new CallbackDigest(filename);
            Thread t = new Thread(cb);
            t.start();
        }
    }
}
