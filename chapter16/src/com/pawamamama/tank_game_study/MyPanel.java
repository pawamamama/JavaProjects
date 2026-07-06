package com.pawamamama.tank_game_study;

import javax.swing.*;
import java.awt.*;

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
public class MyPanel extends JPanel {
    //添加玩家坦克
    Hero hero = null;
    //初始化
    public MyPanel() {
        hero = new Hero(100, 100);//初始化玩家坦克
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //绘制游戏区域
        g.fillRect(0,0, 1000,750);
    }

}