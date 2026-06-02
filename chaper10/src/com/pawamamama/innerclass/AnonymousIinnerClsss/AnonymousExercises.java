package com.pawamamama.innerclass.AnonymousIinnerClsss;

public class AnonymousExercises {
    public static void main(String[] args) {

        // 匿名内部类 + 接口
        // 本质：
        // 临时创建了一个实现 Bell 接口的对象
        // 然后把“行为”当参数传入

        // 第一个铃声行为
        new Cellphone().alarmclock(new Bell() {

            // 重写接口的方法
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

        // 第二个铃声行为
        // 同一个方法
        // 但传入了不同实现
        // 行为立刻改变
        new Cellphone().alarmclock(new Bell() {

            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}


// 铃声接口
// 规定：必须有 ring 方法
interface Bell {

    // 抽象方法
    void ring();
}


class Cellphone {

    // 参数 Bell bell
    // 本质：
    // 接收一个“实现了 Bell 接口的对象”
    public void alarmclock(Bell bell) {

        // 动态调用传入对象的 ring 方法
        // 这里体现接口多态
        bell.ring();
    }
}
