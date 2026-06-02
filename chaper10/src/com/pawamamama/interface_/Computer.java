package com.pawamamama.interface_;

public class Computer {
    //编写一个
    //通过接口可以访问 手机和照相机

    //接口的多态参数
    //可以接收实现了这个接口的类的对象实例
    public void work( UsbInterface usbInterface) {
        //通过接口来调用方法
        usbInterface.start();
        usbInterface.start();
    }
}
