package com.pawamamama.interface_;

//接口的多态
public class InterfacePolyParameter {
    static void main(String[] args) {
        //1.接口参数多态
        //接口类型的变量 iF可以指向实现了IF 接口的对象
        IF iF = new Monster();
        iF = new Car();
    }
}

interface IF {

}

class Monster implements IF {

}

class Car implements IF {
}
