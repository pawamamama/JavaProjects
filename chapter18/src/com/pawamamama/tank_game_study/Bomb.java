package com.pawamamama.tank_game_study;

/**
 * Class: Bomb
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/11
 */
@SuppressWarnings({"all"})
public class Bomb {
    int x;
    int y;
    int life = 9;//生命周期
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown() {//播放三张图片是的动态效果
        if (life > 0) {
            life--;
        } else {
            isLive = false;//标记为该爆炸效果已死亡
        }
    }

}