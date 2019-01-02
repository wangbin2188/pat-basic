package core_technology.chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by wangbin10 on 2019/1/2.
 * 监听器对象是一个实现了监听器接口的实例，ColorAction是监听器；
 * 事件源是一个能够注册监听器对象并发送事件对象的对象，button是事件源；
 * 监听器对象将利用事件对象中的信息对事件作出响应
 */
public class ButtonFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame() throws HeadlessException {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        JButton yellowButton = new JButton("yellow");
        JButton blueButton = new JButton("blue");
        JButton redButton = new JButton("red");

        buttonPanel = new JPanel();
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        add(buttonPanel);

        ColorAction yellowAction = new ColorAction(Color.yellow);
        ColorAction blueAction = new ColorAction(Color.blue);
        ColorAction redAction = new ColorAction(Color.red);

        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);

    }

    public static void main(String[] args) {
        ButtonFrame buttonFrame = new ButtonFrame();
        buttonFrame.show();
    }

    /**
     *内部类
     */
    private class ColorAction implements ActionListener {
        private Color backgroundColor;

        public ColorAction(Color c) {
            this.backgroundColor = c;
        }

        /**
         * ActionEvent——事件对象；
         * 对于一个按钮，动作事件（ActionEvent）就是一个点击
         * 只要用户点击button，JButton对象就会创建一个ActionEvent对象；
         * 然后调用监听器的actionPerformed方法传递ActionEvent对象
         * @param event
         */
        @Override
        public void actionPerformed(ActionEvent event) {
                buttonPanel.setBackground(backgroundColor);

        }
    }
}
