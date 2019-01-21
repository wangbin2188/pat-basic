package java_network.chapter3;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by wangbin10 on 2019/1/21.
 * 示例3-2： 计算多个文件的安全散列算法（SHA）摘要,实现Runnable方式
 */
public class DigestRunnable implements Runnable {
    private String filename;

    public DigestRunnable(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);
            while (din.read()!=-1);
            din.close();
            byte[] digest = sha.digest();
            StringBuilder result = new StringBuilder(filename);
            result.append("= ");
            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (String filename : args) {
            DigestRunnable r = new DigestRunnable(filename);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
