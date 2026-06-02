package com.use;//命名规范 com.公司名.项目名.业务模块名
//常用的包
//java.lang 基本包，默认引入 ,Math.abs(-1)直接用
//java.util 系统提供的工具包工具类 使用Scanner
//Java.net 网络包，网络开发
//java.awt Java界面开发 ，GUI
//如何引入包，com.hspedu.pak
import com.xiaoming.Dog;//引用包
public class Test {
    static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog);

        com.xiaoqiang.Dog dog1 = new com.xiaoqiang.Dog();
        System.out.println(dog1);
    }
}
