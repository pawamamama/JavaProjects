package com.pawamamama.tank_game_teacher;
/**
 * Class: Shot
 *
 * <pre>
 * 子弹类：
 * 用于表示坦克游戏中的一颗子弹。
 *
 * 每个 Shot 对象本身就是一个线程任务，实现 Runnable 接口，
 * 在线程中不断改变子弹的位置，实现子弹飞行效果。
 *
 * 主要功能：
 * 1. 保存子弹的位置坐标(x, y)。
 * 2. 根据发射方向(direction)不断移动子弹。
 * 3. 控制子弹移动速度。
 * 4. 当子弹超出游戏地图范围时，将子弹设置为死亡状态。
 *
 * 线程执行流程：
 * run() 方法启动后：
 * - 每隔50毫秒更新一次子弹坐标。
 * - 根据方向改变 x 或 y 的值。
 * - 检测子弹是否超出边界。
 * - 超出范围后结束线程。
 *
 * 方向说明：
 * 0 : 上
 * 1 : 右
 * 2 : 下
 * 3 : 左
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/10
 */
@SuppressWarnings({"all"})
public class Shot implements Runnable {
    //子弹坐标
    int x;
    int y;
    //子弹方向
    int direct;
    //速度
    int speed = 5;
    //子弹是否存活
    boolean isLive =true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {//run行为是射击行为，不停的去改变子弹位置
        while (true) {
            //子弹休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            //根据方向来改变坐标
            switch (direct) {
                case 0://上
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://下
                    y += speed;
                    break;
                case 3://左
                    x -= speed;
                    break;
            }
            System.out.println(this.x + " " + this.y + " " + this.direct);
            //当子弹移动到面板的边界时，就应该销毁（把启动的子弹线程销毁）
            if (!(x >=0 && x<= 1000 && y >=0 && y <= 750)) {
                System.out.println("子弹线程退出");
                isLive = false;//子弹死了
                break;
            }
        }

    }
}