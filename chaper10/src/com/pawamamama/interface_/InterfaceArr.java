package com.pawamamama.interface_;

public class InterfaceArr {
    static void main(String[] args) {
        //创建接口数组
        UsbInterface[] usb = new UsbInterface[2];
        usb[0] = new Phone();
        usb[1] = new Camera();
        for (int i = 0; i < usb.length ; i++) {
            usb[i].start();
            usb[i].start();
            //是Phone 的实例对象 或者子类吗
            if (usb[i] instanceof  Phone  ) {
                //接口的向下转型
                (( Phone)usb[i]).car();
            }
        }
    }
}
