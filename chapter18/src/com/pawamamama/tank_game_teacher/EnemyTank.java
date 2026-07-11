package com.pawamamama.tank_game_teacher;

import javax.jws.Oneway;
import java.util.Vector;

/**
 * Class: EnemyTank
 *
 * <pre>敌方tank
 *      1.有自己的特殊的属性和方法，所以继承tank类，单开一个EnemyTank类去
 *      2.敌人坦克数量多可以放入到集合内进行管理
 *          将来坦克需要多线程需要使用Vector 集合来管理
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/7
 */
@SuppressWarnings({"all"})
public class EnemyTank extends  Tank {
    //在敌人坦克类，使用Vector 保持多个Shot
    Vector<Shot> shots = new Vector();
    public EnemyTank(int x, int y) {
        super(x, y);
    }
}