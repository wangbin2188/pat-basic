package core_technology.chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by wangbin10 on 2019/1/2.
 */
public class ActionFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;


    public ActionFrame() throws HeadlessException {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new JPanel();
        ColorAction yellowAction = new ColorAction("yellow", new ImageIcon("yellow-ball.git"), Color.yellow);
        ColorAction blueAction = new ColorAction("blue", new ImageIcon("blue-ball.git"), Color.blue);
        ColorAction redAction = new ColorAction("red", new ImageIcon("red-ball.git"), Color.red);

        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));
        add(buttonPanel);
        InputMap inputMap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        /**
         * 设置事件对应的键盘快捷键
         */
        inputMap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        inputMap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
        inputMap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
        /**
         * 得到顶层组件的动作映射，将动作快捷键和对象添加到映射中
         */
        ActionMap actionMap = buttonPanel.getActionMap();
        actionMap.put("panel.yellow", yellowAction);
        actionMap.put("panel.blue", blueAction);
        actionMap.put("panel.red", redAction);

    }

    public static void main(String[] args) {
        ActionFrame actionFrame = new ActionFrame();
        actionFrame.show();
    }

    /**
     * 多个相关或相似动作可以使用同一个类
     * 使用构造器构造对象，按钮和菜单项可以放在构造器中
     */
    class ColorAction extends AbstractAction {

        public ColorAction(String name, Icon icon, Color c) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, name.toLowerCase());
            putValue("color", c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }

}
