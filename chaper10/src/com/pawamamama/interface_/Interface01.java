package com.pawamamama.interface_;

public class Interface01 {
    public static void main(String[] args) {
        //接口可以创建引用类型 ，运行类型可以是实现了这个接口的类
// 接口类型的引用变量 usbInterface
// 当前指向的是 Phone 对象
        UsbInterface usbInterface = new Phone();

// 创建 Computer 对象
        Computer computer = new Computer();

// 调用 Computer 的 work 方法
// 参数类型要求是 UsbInterface
// 这里实际传入的是 Phone 对象
// 这就属于：接口多态参数
// 编译看接口，运行看实际对象（Phone）
        computer.work(usbInterface);

// usbInterface 重新指向 Camera 对象
// 同一个接口引用，可以接收不同实现类对象
        usbInterface = new Camera();

// 把 Camera 对象传入 work 方法
// Computer 不需要关心你到底是手机还是相机
// 只要实现了 UsbInterface 就能接入
// 这体现了接口的统一规范和多态特性
        computer.work(usbInterface);
    }
}
