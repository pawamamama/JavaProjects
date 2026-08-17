package com.pawamamama.tank_game_debug;

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
//为了绘制子弹，要将MyPanel当成一个线程使用
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义玩家坦克
    Hero hero = null;
    //定义玩家初始坐标
    int x = 200;
    int y = 200;
    //定义敌人坦克，放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //敌人个数，初始化为
    int enemyTankSize = 5;
    //定义一个Vector,用于存放炸弹
    //当子弹击中坦克时，就加入一个Bomb对象到Vector
    Vector<Bomb> bombs = new Vector<>();
    //定义三张炸弹图片，用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        hero = new Hero(x, y);//初始化自己的坦克
        //设置速度
        //hero.setSpeed(10);
        //for循环初始化敌方坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //初始化并横向分布敌方坦克
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            //将enemyTanks 设置给 enemyTank,广播给所有敌人
            enemyTank.setEnemyTanks(enemyTanks);
            //初始绘制炮管为向下所以方向要初始化为2
            enemyTank.setDirect(2);
            //启动敌人坦克线程
            new Thread(enemyTank).start();
            //加入到集合中
            enemyTanks.add(enemyTank);

        }
        //初始化炸弹图片
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
    }

    //添加显示我方击毁坦克的信息
    public void showinfo(Graphics g) {
        //画出玩家的总成绩
        g.setColor(Color.black);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);

        g.drawString("累计击毁敌方坦克", 1020, 30);
        this.drawTank(1020, 60, g, 0, 0);//画出一个敌方坦克
        g.setColor(Color.black);
        g.drawString(Recorder.getAllEnemyTankNum() + "", 1080, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //绘制游戏区域
        //绘制玩家信息页面
        showinfo(g);
        //添加颜色
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 1000, 750);
        //恢复默认值
        g.setColor(Color.black);

        //画坦克
        //每次重绘时获取修改过的坐标和方向来进行重绘
        if (hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }
        //画出hero射击子弹->多颗子弹
        for (int i = 0; i < hero.shots.size(); i++) {
            //取出short
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive) {
                g.setColor(Color.white);
                g.draw3DRect(shot.x, shot.y, 1, 1, false);
                g.setColor(Color.black);
            } else {//如果该shot对象已经无效，就拿掉
                hero.shots.remove(shot);
            }
        }
        //画出炸弹
        //如果bombs集合中有炸弹对象就画出爆炸效果
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前bomb对象的life去画出对应的图片
            if (bomb.life > 6) {
                //画比较大的图片
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                //中号图片
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            //让炸弹生命值减少
            bomb.lifeDown();
            //如果bomb isLive为false，就bombs 的集合中删除
            if (bomb.isLive == false) {
                bombs.remove(bomb);
            }
        }
        //画出敌方坦克和子弹
        for (EnemyTank enemyTank : enemyTanks) {
            if (!enemyTank.isLive) {
                continue;
            }

            drawTank(
                    enemyTank.getX(),
                    enemyTank.getY(),
                    g,
                    enemyTank.getDirect(),
                    0
            );

            Vector<Shot> shots = enemyTank.shots;

            for (int j = shots.size() - 1; j >= 0; j--) {
                Shot shot = shots.get(j);

                if (shot == null || !shot.isLive) {
                    shots.remove(j);
                    continue;
                }
                System.out.println("绘制 " + System.identityHashCode(shot)
                        + " 坐标 " + shot.x + "," + shot.y);
                g.setColor(Color.RED);
                g.draw3DRect(shot.x, shot.y, 1, 1, false);
            }

            g.setColor(Color.BLACK);
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

    //多颗子弹击中敌人
    public void hitsTank(Vector<Shot> shots) {
        //重绘时判断子弹是否击中了敌人坦克
        //1.判断我方子弹是否还活着
        for (int i = 0; i < shots.size(); i++) {
            Shot shot = shots.get(i);
            if (shot != null && shot.isLive == true) {//判断子弹是否活着
                for (int j = 0; j < enemyTanks.size(); j++) {
                    //取出坦克,依次对比我方子弹是否击中敌方坦克
                    EnemyTank enemyTank = enemyTanks.get(j);
                    //hitTank(shot, enemyTank);
                    newHitTank(shot,enemyTank,enemyTank);
                }
            } else {
                shots.remove(shot);
            }
        }
    }

    public void hitTank(Shot shot, Tank tank) {
        //判断是否击中坦克
        switch (tank.getDirect()) {
            case 0:
            case 2:
                //上和下敌人坦克
                //认为一样 长60*宽40
                if (shot.x < tank.getX() + 40 && shot.x > tank.getX()
                        && shot.y < tank.getY() + 60 && shot.y > tank.getY()) {
                    //把我方子弹设置为已死亡
                    shot.isLive = false;
                    //把子弹从集合中去掉
                    hero.shots.remove(shot);
                    //把敌人弄死
                    tank.isLive = false;
                    //当我们的子弹击中敌人坦克后，将敌人坦克从Vector中去掉
                    enemyTanks.remove(tank);
                    //当我方击毁一个敌人坦克时，就allEnemyTankNum++
                    if (tank instanceof EnemyTank){
                        Recorder.addallEnemyTankNum();
                    }
                    //创建炸弹对象加入到bombs集合中
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);


                }
                break;
            case 1:
            case 3:
                //左和右敌人坦克认为一样 x =40 * y =60
                if (shot.x < tank.getX() + 60 && shot.x > tank.getX()
                        && shot.y < tank.getY() + 40 && shot.y > tank.getY()) {
                    shot.isLive = false;
                    //把子弹从集合中去掉
                    hero.shots.remove(shot);
                    tank.isLive = false;
                    //当我们的子弹击中敌人坦克后，将敌人坦克从Vector中去掉
                    enemyTanks.remove(tank);
                    //当我方击毁一个敌人坦克时，就allEnemyTankNum++
                    if (tank instanceof EnemyTank){
                        Recorder.addallEnemyTankNum();
                    }
                    //创建炸弹对象加入到bombs集合中
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
        }
    }

    //编写方法判断敌人子弹是否打到我们
    public void hitsHero(Vector<EnemyTank> enemyTanks) {
        //遍历所有敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出敌人的子弹集合
            EnemyTank enemyTank = enemyTanks.get(i);
            Vector<Shot> shots = enemyTank.shots;
            //遍历敌人的子弹集合
            for (int j = 0; j < shots.size(); j++) {
                //取出单个子弹
                Shot shot = shots.get(j);
                //判断是否存活
                if (hero.isLive && shot.isLive) {
                    System.out.println("创建 " + System.identityHashCode(shot)
                            + " 坐标 " + shot.x + "," + shot.y);
                    newHitTank(shot, hero, enemyTank);
                } else if (!shot.isLive) {
                    shots.remove(shot);
                    j--;
                }
            }
        }
    }

    //编写升级版hitTank
    //该方法用于对比坦克是否被击中
    public void newHitTank(Shot shot, Tank tank, EnemyTank enemyTank) {
        int isPass = 0;
        //0 = 没有打到
        //1 = 打到敌方
        //2 = 打到玩家
        switch (tank.getDirect()) {
            case 0:
            case 2:
                //上和下敌人坦克
                //认为一样 长60*宽40
                if (shot.x < tank.getX() + 40 && shot.x > tank.getX()
                        && shot.y < tank.getY() + 60 && shot.y > tank.getY()) {
                    if (tank instanceof Hero) {
                        isPass = 2;
                    } else {
                        isPass = 1;
                    }
                }
                break;
            case 1:
            case 3:
                //左和右敌人坦克认为一样 x =40 * y =60
                if (shot.x < tank.getX() + 60 && shot.x > tank.getX()
                        && shot.y < tank.getY() + 40 && shot.y > tank.getY()) {
                    if (tank instanceof Hero) {
                        isPass = 2;
                    } else {
                        isPass = 1;
                    }
                }
        }
        if (isPass == 0) {
            return;
        }
        if (isPass == 1) {//打到EnemyTank,如果传入的是敌人那子弹肯定是玩家子弹
            EnemyTank enemyTank1 = (EnemyTank) tank;
            //把当前子弹设置为已死亡
            shot.isLive = false;
            //把子弹从集合中删除
            hero.shots.remove(shot);
            tank.isLive = false;
            //当我们的子弹击中敌人坦克后，将敌人坦克从Vector中去掉
            enemyTanks.remove(enemyTank1);
            Recorder.addallEnemyTankNum();
            //创建炸弹对象加入到bombs集合中
            Bomb bomb = new Bomb(enemyTank1.getX(), enemyTank1.getY());
            bombs.add(bomb);
        }
        if (isPass == 2) {//打到的是Hero，删除敌人子弹并把玩家弄死，爆炸效果
            System.out.println("删除 " + System.identityHashCode(shot)
                    + " 坐标 " + shot.x + "," + shot.y);
            shot.isLive = false;
            enemyTank.shots.remove(shot);//删除该敌方坦克的子弹
            System.out.println("删除敌方tank子弹");
            Hero hero = (Hero) tank;
            //把hero弄死
            hero.isLive = false;
            //创建炸弹对象加入到bombs集合中
            Bomb bomb = new Bomb(hero.getX(), hero.getY());
            bombs.add(bomb);
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
        //如果用户按下的是 j 就发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnemyTank();
        }
        //重绘
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔100ms 重绘区域,相当于每隔100ms 刷新绘图区域，子弹就移动

        while (true) {
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hitsTank(hero.shots);//判断玩家子弹击中坦克
            hitsHero(enemyTanks);//敌人是否击中我们
            this.repaint();
        }
    }
}
