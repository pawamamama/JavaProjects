
package com.pawamamama.tank_game_music;

import java.util.Vector;
import java.awt.Rectangle;

/**
 * Class: Hero
 *
 * <pre>
 *     玩家Tank
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/6
 */
@SuppressWarnings({"all"})
public class Hero extends Tank {

    //定义一个Shot对象，表示一个射击行为(线程)
    Shot shot = null;
    //可以发射多颗子弹
    Vector<Shot> shots = new Vector<Shot>();
    int bulletBigSize = 5;
    //定义一个敌人Vector，来进行体积碰撞（防止重叠）
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    /** 判断 Hero 下一步移动后是否会撞到敌人。 */
    public boolean canMove(int direct) {
        int nextX = getX();
        int nextY = getY();
        int speed = getSpeed();

        switch (direct) {
            case 0:
                nextY -= speed;
                break;
            case 1:
                nextX += speed;
                break;
            case 2:
                nextY += speed;
                break;
            case 3:
                nextX -= speed;
                break;
            default:
                break;
        }

        // Hero 的碰撞盒按当前绘制尺寸统一为 60x60。
        Rectangle next = new Rectangle(nextX, nextY, 60, 60);
        for (EnemyTank enemyTank : enemyTanks) {
            if (enemyTank.isLive) {
                int width = (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) ? 40 : 60;
                int height = (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) ? 60 : 40;
                Rectangle enemy = new Rectangle(enemyTank.getX(), enemyTank.getY(), width, height);
                if (next.intersects(enemy)) {
                    return false;
                }
            }
        }
        return nextX >= 0 && nextY >= 0 && nextX + 60 <= 1000 && nextY + 60 <= 750;
    }

    // //当前坦克是否和其他坦克发生了重叠现象或者碰撞
    public boolean isTouchEnemyTank() {
        //判断当前坦克方向
        switch (this.getDirect()) {
            case 0://上
                //让当前this的和其他敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector中一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);

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
                break;
            case 1://右
                //让当前this的和其他敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector中一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不要和自己比较

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
                break;
            case 2://下
                //让当前this的和其他敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector中一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
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
                break;
            case 3://左
                //让当前this的和其他敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从vector中一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);

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
                break;
        }
        return false;
    }


    public Hero(int x, int y) {
        super(x, y);
        setSpeed(5);
    }

    //射击
    public void shotEnemyTank() {
        if (shots.size() == bulletBigSize) {
            return;
        }
        //真正创建Shot对象
        //1.创建对象时，要根据当前Hero对象的位置和方向来创建
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
}
