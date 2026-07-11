package com.pawamamama.tank_game_study;

import java.util.Vector;

/**
 * Class: EnemyTank 敌方坦克
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/7
 */
@SuppressWarnings({"all"})
public class EnemyTank  extends  Tank{
    //敌人是否存活
    boolean isLive = true;
    //敌方子弹线程
    Vector<Shot> shots = new Vector();
    public EnemyTank(int x, int y) {
        super(x, y);
    }
}