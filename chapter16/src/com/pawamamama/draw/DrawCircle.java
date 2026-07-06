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
 *    只要界面发生变化或调用 repaint()，paint() 就会被系统自动执行
 *
 * ------------------------------------------------------------
 * 6. 绘图基本方法（Graphics 常用API）
 * ------------------------------------------------------------
 *
 * （1）设置画笔颜色
 *     g.setColor(Color.blue);
 *     - 作用：设置后续所有绘制内容的颜色
 *     - 影响范围：图形、文字、线条等
 *
 * （2）设置字体
 *     g.setFont(new Font("宋体", Font.BOLD, 50));
 *     - 作用：设置文字的字体样式
 *     - 参数说明：
 *         "宋体" → 字体名称
 *         Font.BOLD → 加粗样式
 *         50 → 字体大小
 *
 * （3）绘制字符串
 *     g.drawString("我是sb", 100, 100);
 *     - 作用：在界面绘制文本
 *     - 坐标说明：
 *         (100,100) 是文字“基线位置”，不是左上角
 *
 * （4）绘制图片
 *     g.drawImage(image, 10, 10, 175, 221, this);
 *     - 作用：在界面绘制图片
 *     - 参数说明：
 *         image → 图片对象
 *         10,10 → 图片左上角坐标
 *         175,221 → 图片缩放后的宽高
 *         this → ImageObserver（用于监听图片加载）
 *
 * ------------------------------------------------------------
 * 7. 方法执行流程（绘图流程）
 * ------------------------------------------------------------
 *
 * repaint() → 系统请求重绘 → paint(Graphics g) 被调用 →
 * 设置颜色/字体 → 绘制图片 → 绘制文字 → 显示到界面
 *
 * ------------------------------------------------------------
 * 8. 总结
 * ------------------------------------------------------------
 * Graphics 绘图的核心步骤：
 *    1. 获取画笔（Graphics g）
 *    2. 设置样式（颜色/字体）
 *    3. 调用绘制方法（drawImage / drawString）
 *    4. 系统刷新显示
 *</pre>
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
        //演示绘制不同的图形，左边点坐上角
        //1.画出一个椭圆
        //g.drawOval(10, 10, 100, 100);
        //2.画出一个直线
        //g.drawLine(10,10,100,100);
        //3.画出矩形边框
        //g.drawRect(10,10,100,200);


        //2.填充色需要设置画笔颜色
        //g.setColor(Color.gray);
        //2.1填充矩形
        //g.fillRect(10,10,100,100);
        //2.2 填充椭圆
        //g.fillOval(10,10,100,100);
        // 3.0 画图片

        // 3.1 获取图片资源（从classpath加载 bg.png）
        Image image = Toolkit.getDefaultToolkit()
                // 获取 AWT 系统工具箱（负责图像、剪贴板等底层功能）
                .getImage(
                        Panel.class.getResource("/bg.png")
                        // 从类路径根目录查找 bg.png，返回 URL
                        // 注意："/" 表示从classpath根目录开始找
                );
        // 3.2 在当前组件上绘制图片
        g.drawImage(
                image,
                10, 10,
                175, 221,
                this
                // 参数1：要绘制的图片对象
                // 参数2：x坐标（距离左边10像素）
                // 参数3：y坐标（距离顶部10像素）
                // 参数4：宽度（将图片缩放到175px宽）
                // 参数5：高度（将图片缩放到221px高）
                // 参数6：ImageObserver（当前组件，用于监听图片加载状态）
        );
        // 4.0 画字符串（在界面上绘制文字）

        // 4.1 设置画笔颜色 and 字体
                g.setColor(Color.blue);
        // 设置当前“画笔颜色”为蓝色
        // 之后所有绘制的图形/文字都会使用这个颜色（除非再次修改）

                g.setFont(new Font("宋体", Font.BOLD, 50));
        // 设置字体
        // 参数1："宋体" → 字体名称（系统需支持该字体，否则会自动替换）
        // 参数2：Font.BOLD → 字体样式（加粗）
        // 参数3：50 → 字体大小（单位：像素，越大文字越大）

        // 4.2 画字符串
                g.drawString("我是sb", 100, 100);
        // 在指定坐标绘制字符串

        // 参数1："我是sb"
        // → 要绘制的文本内容

        // 参数2：100（x坐标）
        // → 文字起点的水平位置（距离左边100像素）

        // 参数3：100（y坐标）
        // → 文字基线位置（不是顶部！）
        // → 注意：Java绘制文字时，y坐标对应的是“文字的基线（baseline）”
        //    不是左上角，所以看起来会比预期稍微往下偏一点

        // ⚠️ 重要细节：
        // drawString 的坐标是“左下基线对齐”，不是左上角对齐
        // 这点是 Swing 绘图常见考点



    }
}