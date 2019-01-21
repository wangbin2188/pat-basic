package java_network.chapter3;

import javax.xml.bind.DatatypeConverter;

/**
 * Created by wangbin10 on 2019/1/21.
 * 这个程序在单线程下是可以正常运行的，但是多线程不可以
 * 原因是dr.getDigest()执行的时候，dr.start()可能还没有运行完，因此也就无法取到正确的结果
 */
public class ReturnDigestUserInterface {
    public static void main(String[] args) {
        for (String filename : args) {
            ReturnDigest dr = new ReturnDigest(filename);
            dr.start();

            byte[] digest = dr.getDigest();
            StringBuilder result = new StringBuilder(filename);
            result.append(": ");
            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);
        }
    }
}
