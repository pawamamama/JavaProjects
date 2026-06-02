package com.pawamamama.abstract_;

public class TestTemplate {
    static void main() {
        new bb().calculateTime();
    }
}
//抽象类的实际使用案例，根据实际创建的子类对象方法通过动态绑定来干活
abstract class aa {
    public void calculateTime() {
        long start = System.currentTimeMillis();
        work();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    abstract void work();
}

class bb extends aa {
    @Override
    void work() {
        for (int i = 0; i < 1101010; i++) {

        }
    }
}
class ccc extends aa {
    @Override
    void work() {
        for (int i = 0; i < 11000000; i++) {
        }
    }
}