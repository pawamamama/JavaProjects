package com.pawamamama.tank_game_teacher;

import javax.swing.*;
import java.awt.*;

/**
 * Class: MyPanel 坦克大战游戏绘图区域
 *
 * <pre>
 *     1.画出游戏区域：长1000 宽 750
 *     2.画出tank基本型：封装到一个方法里 drawTank方法，形参查阅类注释
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/6
 */
@SuppressWarnings({"all"})
public class MyPanel extends JPanel {
    //定义玩家坦克
    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);//初始化自己的坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //做一个填充矩形
        g.fillRect(0, 0, 1000, 750);//默认是黑色
        //画出坦克
        drawTank(hero.getX(), hero.getY(), g, 0, 1);

    }

    /**
     * 绘制坦克（基础模型）- 封装成一个方法供我们使用
     *
     * <p>该方法用于在 JPanel 中绘制一个坦克对象，坐标系以 JPanel 左上角为原点。</p>
     *
     * @param x      坦克左上角 x 坐标（相对于 JPanel）
     * @param y      坦克左上角 y 坐标（相对于 JPanel）
     * @param g      画笔对象（Graphics，用于绘制图形）
     * @param direct 坦克方向（控制朝向：上/下/左/右） 原型 direction
     * @param type   坦克类型（玩家/敌方/特殊单位，用于区分颜色或样式）
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //0.使用 Graphics2D 优化版
        Graphics2D g2 = (Graphics2D) g;
        //1.根据不同类型设置坦克颜色
        // 0 = 玩家 = 天蓝
        // 1 = 敌人 = 黄色
        //先保存一个颜色
        Color base = null;
        switch (type) {
            case 0:
                base = Color.cyan;
                break;
            case 1:
                base = Color.yellow;
                break;
        }
        //同色系创建
        Color dark = base.darker();
        Color light = base.brighter();

        // ===== 状态保存 =====
        Color oldColor = g2.getColor();
        Stroke oldStroke = g2.getStroke();
        try {//开启抗锯齿
            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

        //2.根据坦克方向绘制坦克
        // 0 = 上
        // 1 =
        // 2
        // 3
        switch (direct) {

            case 0: // ↑ 上
                g2.setColor(dark);
                g2.fill3DRect(x, y, 10, 60, true);
                g2.fill3DRect(x + 30, y, 10, 60, true);

                g2.setColor(base);
                g2.fill3DRect(x + 10, y + 10, 20, 40, true);

                g2.setColor(light);
                g2.fillOval(x + 10, y + 20, 20, 20);

                g2.setColor(Color.WHITE);
                g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2.drawLine(x + 20, y + 25, x + 20, y - 15);
                break;

            case 1: // → 右（先简单镜像）
                g2.setColor(dark);
                g2.fill3DRect(x, y, 60, 10, true);
                g2.fill3DRect(x, y + 30, 60, 10, true);

                g2.setColor(base);
                g2.fill3DRect(x + 10, y + 10, 40, 20, true);

                g2.setColor(light);
                g2.fillOval(x + 20, y + 10, 20, 20);

                g2.setColor(Color.WHITE);
                g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2.drawLine(x + 25, y + 20, x + 60, y + 20);
                break;

            default:
                System.out.println("没有坦克要处理");
        }

    } finally {
        g2.setColor(oldColor);
        g2.setStroke(oldStroke);
    }
    }
}