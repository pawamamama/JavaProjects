package com.pawamamama.enum_;

/**
 * @author pawamamama
 *细节
 * 1.使用enum 不能继承其他类 因为enum会隐式继承Java.lang.Enum类
 * 2.枚举类可以实现接口
 */
public class EnumDetail {
    public static void main(String[] args) {
       B.music.playing();
    }
}
interface Playing {
    public void playing();
}
enum B implements Playing {
    music;

    @Override
    public void playing() {
        System.out.println("playing");
    }
}