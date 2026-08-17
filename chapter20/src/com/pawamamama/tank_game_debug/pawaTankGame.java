package com.pawamamama.tank_game_debug;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

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
    static Scanner  scanner = new Scanner(System.in);
    public static void main(String[] args) {
        pawaTankGame pawaTankGame = new pawaTankGame();
    }

    public pawaTankGame() {
        System.out.println("请输入选择1:新游戏 2:继续上局");
        String key = scanner.next();
        mp = new MyPanel(key);
        //将mp放入到 Thread并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);//把面板（游戏区域）放入窗口
        this.setSize(1100, 850);
        this.addKeyListener(mp);//窗口监听键盘输入mp实现了key
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);//默认显示

        //在JFrame中增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                Recorder.keepRecording();
                System.exit(0);
            }
        });
    }
}