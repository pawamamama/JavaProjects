package com.pawamamama.tank_game_teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * Class: MyPanel 坦克大战游戏绘图区域
 *
 * <pre>
 *     1.画出游戏区域：长1000 宽 750
 *     2.画出tank基本型：封装到一个方法里 drawTank方法，形参查阅类注释
 *          2.1 完成了tank的四个方向的绘制
 *     3.通过键盘事件监听让坦克动起来（结合四个方向）绘制
 *          3.1 规定wasd 控制tank 使用KeyListener实现方法 keyPressed 控制上下左右，和重绘操作
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/6
 */
@SuppressWarnings({"all"})
//为了监听 键盘事件，实现KeyListener
public class MyPanel extends JPanel implements KeyListener {
    //定义玩家坦克
    Hero hero = null;
    //定义玩家初始坐标
    int x = 100;
    int y = 100;
    //定义敌人坦克，放入到Vector
    Vector<EnemyTank> enemyTanks = new  Vector<>();
    //敌人个数，初始化为三
    int enemyTankSize = 3;
    public MyPanel() {
        hero = new Hero(x, y);//初始化自己的坦克
        //设置速度
        //hero.setSpeed(10);
        //for循环初始化敌方坦克
        for (int i = 0; i <enemyTankSize ; i++) {
            //初始化并横向分布敌方坦克
            EnemyTank enemyTank = new EnemyTank(150 * (i + 1), 0);
            //初始绘制炮管为向下所以方向要初始化为2
            enemyTank.setDirect(2);
            //加入到集合中
            enemyTanks.add(enemyTank);

        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //做一个填充矩形
        g.fillRect(0, 0, 1000, 750);//默认是黑色
        //每次重绘时获取修改过的坐标和方向来进行重绘
        //绘制玩家坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        //绘制出敌方坦克，变量Vector
        for (int i = 0; i <enemyTankSize ; i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),0);
        }

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
        // 0 = 天蓝
        // 1 = 黄色
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
            // direct 表示方向
            // 0 = 上
            // 1 = 向右
            // 2 = 向下
            // 3 = 向左
            switch (direct) {
                case 0: // ↑ 向上

                    // 履带
                    g2.setColor(dark);
                    g2.fill3DRect(x, y, 10, 60, true);
                    g2.fill3DRect(x + 30, y, 10, 60, true);

                    // 中心方块
                    g2.setColor(light);
                    g2.fill3DRect(x + 10, y + 10, 20, 40, true);

                    // 中心圆
                    g2.setColor(dark);
                    g2.fillOval(x + 10, y + 20, 20, 20);

                    // 炮管
                    g2.setColor(Color.WHITE);
                    g2.setStroke(new BasicStroke(
                            4,
                            BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND
                    ));

                    g2.drawLine(
                            x + 20,
                            y + 30,
                            x + 20,
                            y
                    );

                    break;


                case 1: // → 向右

                    // 履带
                    g2.setColor(dark);
                    g2.fill3DRect(x, y, 60, 10, true);
                    g2.fill3DRect(x, y + 30, 60, 10, true);

                    // 中心方块
                    g2.setColor(light);
                    g2.fill3DRect(x + 10, y + 10, 40, 20, true);

                    // 中心圆
                    g2.setColor(dark);
                    g2.fillOval(x + 20, y + 10, 20, 20);

                    // 炮管
                    g2.setColor(Color.WHITE);
                    g2.setStroke(new BasicStroke(
                            4,
                            BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND
                    ));

                    g2.drawLine(
                            x + 30,
                            y + 20,
                            x + 60,
                            y + 20
                    );

                    break;


                case 2: // ↓ 向下

                    // 履带
                    g2.setColor(dark);
                    g2.fill3DRect(x, y, 10, 60, true);
                    g2.fill3DRect(x + 30, y, 10, 60, true);

                    // 中心方块
                    g2.setColor(light);
                    g2.fill3DRect(x + 10, y + 10, 20, 40, true);

                    // 中心圆
                    g2.setColor(dark);
                    g2.fillOval(x + 10, y + 20, 20, 20);

                    // 炮管
                    g2.setColor(Color.WHITE);
                    g2.setStroke(new BasicStroke(
                            4,
                            BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND
                    ));

                    g2.drawLine(
                            x + 20,
                            y + 30,
                            x + 20,
                            y + 60
                    );

                    break;


                case 3: // ← 向左

                    // 履带
                    g2.setColor(dark);
                    g2.fill3DRect(x, y, 60, 10, true);
                    g2.fill3DRect(x, y + 30, 60, 10, true);

                    // 中心方块
                    g2.setColor(light);
                    g2.fill3DRect(x + 10, y + 10, 40, 20, true);

                    // 中心圆
                    g2.setColor(dark);
                    g2.fillOval(x + 20, y + 10, 20, 20);

                    // 炮管
                    g2.setColor(Color.WHITE);
                    g2.setStroke(new BasicStroke(
                            4,
                            BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND
                    ));

                    g2.drawLine(
                            x + 30,
                            y + 20,
                            x,
                            y + 20
                    );

                    break;


                default:
                    System.out.println("暂时没有处理");
            }


        } finally {
            g2.setColor(oldColor);
            g2.setStroke(oldStroke);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wasd 键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W
                || e.getKeyCode() == KeyEvent.VK_UP) {       // 上
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D
                || e.getKeyCode() == KeyEvent.VK_RIGHT) {   // 右
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S
                || e.getKeyCode() == KeyEvent.VK_DOWN) {    // 下
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A
                || e.getKeyCode() == KeyEvent.VK_LEFT) {    // 左
            hero.setDirect(3);
            hero.moveLeft();
        }
        //重绘
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}