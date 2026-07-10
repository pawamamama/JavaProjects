package com.pawamamama.tank_game_teacher;

import javax.swing.*;

/**
 * Class: pawaTankGame 游戏窗口区域
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/6
 */
@SuppressWarnings({"all"})
public class pawaTankGame extends JFrame {
    //定义Mypanel
    MyPanel mp = null;
    public static void main(String[] args) {
        new pawaTankGame();
    }

    public pawaTankGame() {
        mp = new MyPanel();
        this.add(mp);//把面板（游戏区域）放入窗口
        this.setSize(1000,750);
        this.addKeyListener(mp);//窗口监听键盘输入mp实现了key
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);//默认显示
    }
}