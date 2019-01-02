package core_technology.chapter10;

import javax.swing.*;

/**
 * Created by wangbin10 on 2019/1/2.
 * 创建一个测试鼠标事件的框架
 */
public class MouseFrame extends JFrame{
    public MouseFrame() {
        add(new MouseComponent());
        pack();
    }

    public static void main(String[] args) {
        MouseFrame mouseFrame = new MouseFrame();
        mouseFrame.show();
    }
}
