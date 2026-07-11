package com.pawamamama.tank_game_study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * Class: MyPanel
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/6
 */
@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener, Runnable {


    //添加玩家坦克
    Hero hero = null;
    int x = 100;
    int y = 100;
    //添加敌方坦克集合
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //敌人坦克数量
    int enemyTanksSize = 3;

    //初始化
    public MyPanel() {
        hero = new Hero(x, y);//初始化玩家坦克
        //for初始化敌人坦克
        for (int i = 0; i < enemyTanksSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirect(2);
            //初始化子弹，后面可以有多个
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            //把子弹放入到Vector集合
            enemyTank.shots.add(shot);
            //启动敌人子弹线程
            new Thread(shot).start();

            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //绘制游戏区域
        //添加颜色
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 1000, 750);
        //恢复默认值
        g.setColor(Color.black);


        //绘制坦克到画板
        //玩家坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        //子弹绘制
        if (hero.shot != null && hero.shot.isLive == true) {
            g.setColor(Color.white);
            g.draw3DRect(hero.shot.x, hero.shot.y, 1, 1, false);
            g.setColor(Color.black);
        }
        //敌人坦克
        for (int i = 0; i < enemyTanksSize; i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            //判断敌人是否存活
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                //绘制敌人坦克子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出敌人子弹
                    Shot shot = enemyTank.shots.get(j);
                    //绘制敌人子弹前先判断
                    if (shot != null && shot.isLive == true) {
                        g.setColor(Color.red);
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                        g.setColor(Color.black);
                    } else {//子弹死亡就把它从集合中移除
                        enemyTank.shots.remove(shot);
                    }

                }
            }
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

                case 0: // ↑ 上
                    g2.setColor(dark);
                    g2.fill3DRect(x, y, 10, 60, true);
                    g2.fill3DRect(x + 30, y, 10, 60, true);

                    g2.setColor(light);
                    g2.fill3DRect(x + 10, y + 10, 20, 40, true);

                    g2.setColor(dark);
                    g2.fillOval(x + 10, y + 20, 20, 20);

                    g2.setColor(Color.WHITE);
                    g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2.drawLine(x + 20, y + 25, x + 20, y - 5);
                    break;

                case 1: // → 右（先简单镜像）
                    g2.setColor(dark);
                    g2.fill3DRect(x, y, 60, 10, true);
                    g2.fill3DRect(x, y + 30, 60, 10, true);

                    g2.setColor(light);
                    g2.fill3DRect(x + 10, y + 10, 40, 20, true);

                    g2.setColor(dark);
                    g2.fillOval(x + 20, y + 10, 20, 20);

                    g2.setColor(Color.WHITE);
                    g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2.drawLine(x + 25, y + 20, x + 55, y + 20);
                    break;
                case 2: // ↓ 下
                    g2.setColor(dark);
                    g2.fill3DRect(x, y, 10, 60, true);
                    g2.fill3DRect(x + 30, y, 10, 60, true);

                    g2.setColor(light);
                    g2.fill3DRect(x + 10, y + 10, 20, 40, true);

                    g2.setColor(dark);
                    g2.fillOval(x + 10, y + 20, 20, 20);

                    g2.setColor(Color.WHITE);
                    g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

                    // 炮管向下
                    g2.drawLine(x + 20, y + 35, x + 20, y + 65);
                    break;


                case 3: // ← 左
                    g2.setColor(dark);
                    g2.fill3DRect(x, y, 60, 10, true);
                    g2.fill3DRect(x, y + 30, 60, 10, true);
                    g2.setColor(light);
                    g2.fill3DRect(x + 10, y + 10, 40, 20, true);

                    g2.setColor(dark);
                    g2.fillOval(x + 20, y + 10, 20, 20);

                    g2.setColor(Color.WHITE);
                    g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

                    // 炮管向左
                    g2.drawLine(x + 25, y + 20, x - 5, y + 20);
                    break;

                default:
                    System.out.println("没有坦克要处理");
            }

        } finally {
            g2.setColor(oldColor);
            g2.setStroke(oldStroke);
        }


    }

    //我方子弹射击到敌人
    public static void hitTank(Shot heroShot, EnemyTank enemyTank) {
        //判断是否击中坦克
        switch (enemyTank.getDirect()) {
            case 0:
            case 2:
                //上和下敌人坦克
                //认为一样 长60*宽40
                if (heroShot.x < enemyTank.getX() + 40 && heroShot.x > enemyTank.getX()
                        && heroShot.y < enemyTank.getY() + 60 && heroShot.y > enemyTank.getY()) {
                    //把我方子弹设置为已死亡
                    heroShot.isLive = false;
                    //把敌人弄死
                    enemyTank.isLive = false;

                }
                break;
            case 1:
            case 3:
                //左和右敌人坦克认为一样 x =40 * y =60
                if (heroShot.x < enemyTank.getX() + 60 && heroShot.x > enemyTank.getX()
                        && heroShot.y < enemyTank.getY() + 40 && heroShot.y > enemyTank.getY()) {
                    heroShot.isLive = false;
                    enemyTank.isLive = false;
                }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //移动
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP
                || e.getKeyCode() == KeyEvent.VK_W) {
            //设置坦克移动方向
            hero.setDirect(0);
            hero.moveUp();//移动坦克坐标
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT
                || e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN
                || e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT
                || e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        }
        //按下j键射击
        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnemyTank();
        }
        repaint();//重绘

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            //每隔16ms刷新
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //判断子弹是否打到敌人
            if (hero.shot != null && hero.shot.isLive == true) {
                //遍历所有敌人的位置
                for (int i = 0; i < enemyTanksSize; i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(hero.shot, enemyTank);
                }
            }
            this.repaint();//重绘整个区域
        }
    }
}
