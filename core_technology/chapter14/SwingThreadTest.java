package core_technology.chapter14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by wangbin10 on 2019/1/4.
 * 将线程与Swing共同工作时，需要遵循两个原则：
 * 1.如果一个动作需要花费很长时间，在一个独立的工作线程中做这件事，不要在事件分配线程中做
 * 2.除了事件分配线程，不要在任何线程中接触swing组件
 * 在这个程序中，Good可以正常工作，Bad就好报错
 */
public class SwingThreadTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new SwingThreadFrame();
                frame.setTitle("SwingThreadTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}


class SwingThreadFrame extends JFrame {
    public SwingThreadFrame() throws HeadlessException {
        JComboBox<Integer> combo = new JComboBox<>();
        combo.insertItemAt(Integer.MAX_VALUE, 0);
        combo.setPrototypeDisplayValue(combo.getItemAt(0));
        combo.setSelectedIndex(0);
        JPanel panel = new JPanel();
        JButton goodButton = new JButton("Good");
        goodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new GoodWorkerRunnable(combo)).start();
            }
        });
        panel.add(goodButton);

        JButton badButton = new JButton("Bad");
        badButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new BadWorkerRunnable(combo)).start();
            }
        });
        panel.add(badButton);
        panel.add(combo);
        add(panel);
        pack();
    }
}

class BadWorkerRunnable implements Runnable {
    private JComboBox<Integer> combo;
    private Random generator;

    public BadWorkerRunnable(JComboBox<Integer> combo) {
        this.combo = combo;
        this.generator = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                int i = Math.abs(generator.nextInt());
                if (i % 2 == 0) {
                    combo.insertItemAt(i, 0);
                } else if (combo.getItemCount() > 0) {
                    combo.removeItemAt(i % combo.getItemCount());
                }
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class GoodWorkerRunnable implements Runnable {
    private JComboBox<Integer> combo;
    private Random generator;

    public GoodWorkerRunnable(JComboBox<Integer> combo) {
        this.combo = combo;
        this.generator = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int i = Math.abs(generator.nextInt());
                        if (i % 2 == 0) {
                            combo.insertItemAt(i, 0);
                        } else if (combo.getItemCount() > 0) {
                            combo.removeItemAt(i % combo.getItemCount());
                        }
                    }
                });
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
