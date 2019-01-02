package core_technology.chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wangbin10 on 2019/1/2.
 */
public class ButtonFrame3 extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame3() throws HeadlessException {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.buttonPanel = new JPanel();
        makeButton("yellow",Color.yellow);
        makeButton("blue",Color.blue);
        makeButton("red",Color.red);
        add(buttonPanel);
    }

    public void makeButton(String name,final Color backgroundColor) {
        JButton button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setBackground(backgroundColor);
            }
        });
    }

    public static void main(String[] args) {
        ButtonFrame3 buttonFrame3 = new ButtonFrame3();
        buttonFrame3.show();
    }
}
