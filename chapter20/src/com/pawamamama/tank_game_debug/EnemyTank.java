package com.pawamamama.tank_game_debug;

import java.util.Vector;

/**
 * Class: EnemyTank
 *
 * <pre>敌方tank
 *      1.有自己的特殊的属性和方法，所以继承tank类，单开一个EnemyTank类去
 *      2.敌人坦克数量多可以放入到集合内进行管理
 *          将来坦克需要多线程需要使用Vector 集合来管理
 *      3.实现坦克自由移动
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/7
 */
@SuppressWarnings({"all"})
public class EnemyTank extends Tank implements Runnable {
    //敌人走一步的步数
    int go = 30;
    //敌人休眠时间
    int sleep = 100;
    //在敌人坦克类，使用Vector 保持多个Shot
    Vector<Shot> shots = new Vector();
    //增加成员， EnemyTank 可以得到所有坦克的Vector
    //1.Vector<EnemyTank> enemyTanks在panel类
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //敌人坦克发射子弹最大值
    int bulletBigSize = 5;


    public EnemyTank(int x, int y) {

        super(x, y);
        setSpeed(3);
    }
    public EnemyTank(int x, int y, int direct) {
        super(x, y,direct);
        setSpeed(3);
    }


    //myPanel 对象的EnemyTanks 设置过来
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //当前坦克是否和其他坦克发生了重叠现象或者碰撞
    public boolean isTouchEnemyTank() {
        //判断当前坦克方向
        switch (this.getDirect()) {
            case 0://上
                //让当前this的和其他敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector中一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不要和自己比较
                    if (enemyTank != this) {
                        //如果敌人坦克是上下
                        //范围是[x,x+40][y,y+60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //1.this坦克左上角坐标[x][y]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() <= enemyTank.getX() + 40 &&
                                    this.getY() >= enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //2. this坦克右上角坐标[x+40][y]
                            if (this.getX() + 40 >= enemyTank.getX() &&
                                    this.getX() + 40 <= enemyTank.getX() + 40 &&
                                    this.getY() >= enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }


                        }
                        //如果敌人坦克是左右
                        //范围是[x,x+60][y,y+40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //1.this坦克左上坐标[x][y]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() <= enemyTank.getX() + 60 &&
                                    this.getY() >= enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //2. this坦克右上角坐标[x+40][y]
                            if (this.getX() + 40 >= enemyTank.getX() &&
                                    this.getX() + 40 <= enemyTank.getX() + 60 &&
                                    this.getY() >= enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }

                }
                break;
            case 1://右
                //让当前this的和其他敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector中一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不要和自己比较
                    if (enemyTank != this) {
                        //如果敌人坦克是上下
                        //范围是[x,x+40][y,y+60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //1.this坦克右上角坐标[x+60][y]
                            if (this.getX() + 60 >= enemyTank.getX() &&
                                    this.getX() + 60 <= enemyTank.getX() + 40 &&
                                    this.getY() >= enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //2. this坦克右下坐标[x+60][y+40]
                            if (this.getX() + 60 >= enemyTank.getX() &&
                                    this.getX() + 60 <= enemyTank.getX() + 40 &&
                                    this.getY() + 40 >= enemyTank.getY() &&
                                    this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }


                        }
                        //如果敌人坦克是左右
                        //范围是[x,x+60][y,y+40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //1.this坦克右上角坐标[x+60][y]
                            if (this.getX() + 60 >= enemyTank.getX() &&
                                    this.getX() + 60 <= enemyTank.getX() + 60 &&
                                    this.getY() >= enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //2. this坦克右下角坐标[x+60][y+40]
                            if (this.getX() + 60 >= enemyTank.getX() &&
                                    this.getX() + 60 <= enemyTank.getX() + 60 &&
                                    this.getY() + 40 >= enemyTank.getY() &&
                                    this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }

                }
                break;
            case 2://下
                //让当前this的和其他敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector中一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不要和自己比较
                    if (enemyTank != this) {
                        //如果敌人坦克是上下
                        //范围是[x,x+40][y,y+60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //1.this坦克左下角坐标[x][y+60]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() <= enemyTank.getX() + 40 &&
                                    this.getY() + 60 >= enemyTank.getY() &&
                                    this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //2. this坦克右下坐标[x+40][y+60]
                            if (this.getX() + 40 >= enemyTank.getX() &&
                                    this.getX() + 40 <= enemyTank.getX() + 40 &&
                                    this.getY() + 60 >= enemyTank.getY() &&
                                    this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }


                        }
                        //如果敌人坦克是左右
                        //范围是[x,x+60][y,y+40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //1.this坦克左下角坐标[x][y+60]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() <= enemyTank.getX() + 60 &&
                                    this.getY() + 60 >= enemyTank.getY() &&
                                    this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //2. this坦克右下坐标[x+40][y+60]
                            if (this.getX() + 40 >= enemyTank.getX() &&
                                    this.getX() + 40 <= enemyTank.getX() + 60 &&
                                    this.getY() + 60 >= enemyTank.getY() &&
                                    this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }

                }
                break;
            case 3://左
                //让当前this的和其他敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector中一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不要和自己比较
                    if (enemyTank != this) {
                        //如果敌人坦克是上下
                        //范围是[x,x+40][y,y+60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //1.this坦克左上角坐标[x][y]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() <= enemyTank.getX() + 40 &&
                                    this.getY() >= enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //2. this坦克左下坐标[x][y+40]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() <= enemyTank.getX() + 40 &&
                                    this.getY() + 40 >= enemyTank.getY() &&
                                    this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }


                        }
                        //如果敌人坦克是左右
                        //范围是[x,x+60][y,y+40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //1.this坦克左上角坐标[x][y]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() <= enemyTank.getX() + 60 &&
                                    this.getY() >= enemyTank.getY() &&
                                    this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //2. this坦克左下坐标[x][y+40]
                            if (this.getX() >= enemyTank.getX() &&
                                    this.getX() <= enemyTank.getX() + 60 &&
                                    this.getY() + 40 >= enemyTank.getY() &&
                                    this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }

                }
                break;
        }
        return false;
    }

    //发射子弹方法
    private void shotHero() {
        //临时变量
        Shot shot = null;
        switch (getDirect()) {

            case 0: // 向上
                shot = new Shot(getX() + 20, getY(), 0);
                break;

            case 1: // 向右
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;

            case 2: // 向下
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;

            case 3: // 向左
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }
        //把shot加入到集合中
        shots.add(shot);
        //启动射击线程
        Thread thread = new Thread(shot);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            //如果shots size() < 5 && isLive == true
            if (shots.size() < 5 && isLive) {
                //就发射子弹
                shotHero();
            }
            //根据坦克的方向来继续移动
            switch (getDirect()) {
                case 0://上
                    for (int i = 0; i < go; i++) {
                        if (!isTouchEnemyTank()){
                            moveUp();
                        }

                        try {
                            Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < go; i++) {
                        if (!isTouchEnemyTank()) {
                            moveRight();
                        }

                        try {
                            Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < go; i++) {
                        if (!isTouchEnemyTank()) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < go; i++) {
                        if (!isTouchEnemyTank()) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                        }
                    }
                    break;
            }
            //然后随机的改变坦克方向 0~3的整数
            setDirect((int) (Math.random() * 4));
            //写多线程并发程序一定要考虑线程什么时候结束
            if ((!isLive)) {//死了就退出线程
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "EnemyTank{" +
                "shots=" + shots +
                '}';
    }
}