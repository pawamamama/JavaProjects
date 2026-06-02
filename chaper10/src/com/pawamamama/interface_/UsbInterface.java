package com.pawamamama.interface_;

public interface UsbInterface {
    //规定接口的相关方法
    public void start();
    public void stop();
}

//Phone 实现 UsbInterface
//Phone类需要实现USB接口规定/声明的方法
class Phone implements UsbInterface {
    //
    @Override
    public void start() {
        System.out.println("start");
    }

    //
    @Override
    public void stop() {
        System.out.println("stop");
    }

    public void car() {
        System.out.println(" phone-car");
    }
}
//实现接口
class Camera implements UsbInterface {
    //把接口的方法实现
    @Override
    public void start() {
        System.out.println("相机开始start");
    }

    @Override
    public void stop() {
        System.out.println("相机stop");
    }
}