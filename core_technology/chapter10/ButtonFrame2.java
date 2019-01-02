package core_technology.chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wangbin10 on 2019/1/2.
 * 使用匿名内部类
 */
public class ButtonFrame2  extends JFrame{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame2() throws HeadlessException {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        JButton yellowButton = new JButton("yellow");
        JButton blueButton = new JButton("blue");
        JButton redButton = new JButton("red");

        buttonPanel = new JPanel();
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        add(buttonPanel);

        yellowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yellowButton.setBackground(Color.yellow);
            }
        });

        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blueButton.setBackground(Color.blue);
            }
        });

        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redButton.setBackground(Color.red);
            }
        });


    }

    public static void main(String[] args) {
        ButtonFrame2 buttonFrame2 = new ButtonFrame2();
        buttonFrame2.show();
    }
}
