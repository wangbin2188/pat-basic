package core_technology.chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by wangbin10 on 2019/1/2.
 */
public class MouseComponent extends JComponent {
    private static final int SIDE_LENGTH = 10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current;

    public MouseComponent() {
        squares = new ArrayList<>();
        current = null;
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        for (Rectangle2D square : squares) {
            g2.draw(square);
        }
    }

    /**
     * 在正方形集合中查找目标正方形
     * @param point2D
     * @return
     */
    public Rectangle2D find(Point2D point2D) {
        for (Rectangle2D square : squares) {
            if (square.contains(point2D)) {
                return square;
            }
        }
        return null;
    }

    public void add(Point2D point2D) {
        double x = point2D.getX();
        double y = point2D.getY();
        current = new Rectangle2D.Double(x - SIDE_LENGTH / 2, y - SIDE_LENGTH / 2, SIDE_LENGTH, SIDE_LENGTH);
        squares.add(current);
        repaint();
    }

    public void remove(Rectangle2D rectangle2D) {
        if (rectangle2D == null) {
            return;
        }
        if (rectangle2D == current) {
            current = null;
        }
        squares.remove(rectangle2D);
        repaint();
    }

    /**
     * 鼠标监听器
     */
    private class MouseHandler extends MouseAdapter {
        /**
         * 鼠标点击，分两种情况，如果当前位置正方形已存在，则不做动作，否则绘制正方形
         * @param event
         */
        public void mousePressed(MouseEvent event) {
            current = find(event.getPoint());
            if (current == null) {
                add(event.getPoint());
            }
        }

        /**
         * 鼠标双击，擦除正方形
         * @param event
         */
        public void mouseClicked(MouseEvent event) {
            current = find(event.getPoint());
            if (current != null && event.getClickCount() >= 2) {
                remove(current);
            }
        }
    }

    /**
     * 鼠标移动监听器
     */
    private class MouseMotionHandler implements MouseMotionListener {
        @Override
        public void mouseMoved(MouseEvent event) {
            if (find(event.getPoint()) == null) {
                setCursor(Cursor.getDefaultCursor());
            }
        }

        /**
         * 鼠标拖拽正方形
         * getX(),getY()用于获取鼠标所在坐标
         * @param event
         */
        @Override
        public void mouseDragged(MouseEvent event) {
            if (current != null) {
                int x=event.getX();
                int y=event.getY();
                current.setFrame(x- SIDE_LENGTH /2,y- SIDE_LENGTH /2, SIDE_LENGTH, SIDE_LENGTH);
                repaint();
            }
        }
    }





}

