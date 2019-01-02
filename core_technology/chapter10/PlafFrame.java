package core_technology.chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wangbin10 on 2019/1/2.
 * 动态改变外观风格
 */
public class PlafFrame extends JFrame {
    private JPanel buttonPanel;

    public PlafFrame() throws HeadlessException {
        buttonPanel = new JPanel();
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos) {
            makeButton(info.getName(), info.getClassName());
        }
        add(buttonPanel);
        pack();
    }

    private void makeButton(String name,final String plafName) {
        JButton button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel(plafName);
                    SwingUtilities.updateComponentTreeUI(PlafFrame.this);
                    pack();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        PlafFrame plafFrame = new PlafFrame();
        plafFrame.show();
    }
}
