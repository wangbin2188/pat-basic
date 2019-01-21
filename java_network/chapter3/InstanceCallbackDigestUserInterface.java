package java_network.chapter3;

import javax.xml.bind.DatatypeConverter;

/**
 * Created by wangbin10 on 2019/1/21.
 * 主类的各个实例只映射一个文件，可以自然的跟踪记录这个文件的信息
 * 不要在构造函数中启动线程
 */
public class InstanceCallbackDigestUserInterface {
    private String filename;
    private byte[] digest;

    public InstanceCallbackDigestUserInterface(String filename) {
        this.filename = filename;
    }

    public void receiveDigest(byte[] digest) {
        this.digest = digest;
        System.out.println(this);
    }

    private void calculateDigest() {
        InstanceCallbackDigest r = new InstanceCallbackDigest(filename, this);
        Thread thread = new Thread(r);
        thread.start();
    }

    public static void main(String[] args) {

        for (String filename : args) {
            InstanceCallbackDigestUserInterface d = new InstanceCallbackDigestUserInterface(filename);
            d.calculateDigest();
        }
    }

    @Override
    public String toString() {
        String result = this.filename + ":";
        if (this.digest != null) {
            result += DatatypeConverter.printHexBinary(digest);
        } else {
            result += "digest is not available";
        }
        return result;
    }
}
