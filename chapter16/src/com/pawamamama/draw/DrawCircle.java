package com.pawamamama.draw;

import javax.swing.*;
import java.awt.*;

/**
 * 绘图原理说明：
 *<pre>
 * 1. Component 类提供两个与绘图相关的重要方法：
 *    - paint(Graphics g)：负责绘制组件的外观
 *    - repaint()：用于刷新组件外观
 *
 * 2. paint(Graphics g) 的调用时机：
 *    - 组件第一次显示在屏幕上
 *    - 窗口最小化再最大化
 *    - 窗口大小发生变化
 *    - 调用 repaint() 方法时
 *
 * 3. repaint() 的作用：
 *    - 触发系统重新调用 paint() 方法进行重绘
 *
 * 4. 核心机制：
 *    系统不会直接调用 paint()，而是通过 repaint() 申请重绘，
 *    最终由 AWT/Swing 事件机制调用 paint(Graphics g)
 *
 * 5. 结论：
 *    只要界面发生变化或调用 repaint()，paint() 就会被系统自动执行</pre>
 */
@SuppressWarnings({"all"})
//继承窗口类
public class DrawCircle extends JFrame {//可以理解成一个画框
    //定义一个面版
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口（画框中）
        this.add(mp);
        //设置窗口大小
        this.setSize(400, 300);
        //设置默认关闭操作,             //点击程序x号完全退出退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可以显示到屏幕
    }
}

//1.定义一个面板MyPanel,继承一个JPanel类，画图形就在面板上画
class MyPanel extends JPanel {
    // 1. MyPanel 对象是一个画板
    // 2. Graphics g 理解成一支画笔
    // 3. Graphics 提供了很多绘图的方法
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类的方法完成初始化
        System.out.println("paint 方法被调用~");
        //画出一个圆
        g.drawOval(10, 10, 100, 100);

    }
}