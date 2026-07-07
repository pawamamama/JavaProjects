package com.pawamamama.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class: BallMove
 *
 * <pre> 事件处理机制 - 小球的移动
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/7
 */
@SuppressWarnings({"all"})

public class BallMove  extends JFrame{ //窗口
    MyPanel mp = null;
    public static void main(String[] args) {
        new BallMove();
    }
    //构造器
    public  BallMove() {
        mp= new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        /**
         * 注册键盘监听器
         *
         * 因为 MyPanel 实现了 KeyListener 接口，
         * 所以 MyPanel 对象可以作为 KeyListener 使用。
         *
         * 接口多态：
         *
         * KeyListener listener = new MyPanel();
         *
         * 接口引用可以指向实现该接口的对象。
         */
        this.addKeyListener(mp);
        // 设置关闭窗口时结束程序
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // 显示窗口
        this.setVisible(true);
    }

}
/**
 * 小球移动面板
 *
 * <pre>
 * 功能说明：
 * 1. 继承 JPanel，作为游戏绘制区域。
 * 2. 实现 KeyListener 接口，用于监听键盘输入。
 * 3. 根据用户按下的方向键修改小球坐标。
 * 4. 调用 repaint() 通知 Swing 重新绘制界面。
 *
 * 移动流程：
 * 键盘按下
 *      ↓
 * keyPressed() 方法触发
 *      ↓
 * 修改 x、y 坐标
 *      ↓
 * repaint()
 *      ↓
 * paint() 根据新的坐标重新绘制小球
 * </pre>
 */
class MyPanel extends JPanel implements KeyListener {

    /**
     * 小球左上角 X 坐标
     */
    int x = 100;

    /**
     * 小球左上角 Y 坐标
     */
    int y = 100;

    /**
     * 小球每次移动的距离（像素）
     */
    int speed = 5;


    /**
     * 绘制面板内容
     *
     * <pre>
     * paint() 会在组件需要显示或刷新时被 Swing 调用。
     * 根据当前 x、y 坐标绘制小球。
     * </pre>
     *
     * @param g 绘图对象，用于绘制图形
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 根据当前坐标绘制圆形小球
        g.fillOval(x, y, 50, 50);
    }


    /**
     * 键盘字符输入事件
     *
     * <pre>
     * 当输入可显示字符时触发，例如：
     * 输入字母、数字等。
     * 本案例只监听方向键，因此不处理。
     * </pre>
     *
     * @param e 键盘事件对象
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }


    /**
     * 键盘按下事件
     *
     * <pre>
     * 根据按下的方向键修改小球坐标：
     *
     * ↓  y增加，小球向下移动
     * ↑  y减少，小球向上移动
     * ←  x减少，小球向左移动
     * →  x增加，小球向右移动
     *
     * 修改坐标后调用 repaint()
     * 让 Swing 重新执行绘制方法。
     * </pre>
     *
     * @param e 键盘事件对象
     */
    @Override
    public void keyPressed(KeyEvent e) {

        // 获取当前按下按键对应的 code 值
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_DOWN) {

            // 向下移动，Y 坐标增加
            y += speed;

        } else if (keyCode == KeyEvent.VK_UP) {

            // 向上移动，Y 坐标减少
            y -= speed;

        } else if (keyCode == KeyEvent.VK_LEFT) {

            // 向左移动，X 坐标减少
            x -= speed;

        } else if (keyCode == KeyEvent.VK_RIGHT) {

            // 向右移动，X 坐标增加
            x += speed;
        }

        // 通知 Swing 更新界面
        repaint();
    }


    /**
     * 键盘释放事件
     *
     * <pre>
     * 当用户松开按键时触发。
     * 本案例不需要处理，因此为空。
     * 在游戏中通常用于：
     * 记录停止移动状态。
     * </pre>
     *
     * @param e 键盘事件对象
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}