package com.pawamamama.final_;

public class FinalDetail01 {
    static void main() {


    }
}


class AA {
    //定义常量就得赋值，三种方式
    //1.定义时赋值
    public final double TAX_RATE1 = 0.008;
    //2.在构造器中
    public final double TAX_RATE2;
    public final double TAX_RATE3;
    public AA(double TAX_RATE) {
        this.TAX_RATE2 = TAX_RATE;
    }
    //3.在代码块中
    {
        this.TAX_RATE3 = 0.030;
    }

}

class BB {
    //如果常量是静态常量 则不能在构造器和普通代码块里去定义
    //1.直接定义
    public static final double TAX_RATE1 = 0.001;
    //2.在静态代码块去定义
    public static final double TAX_RATE2;
    static {
         TAX_RATE2 = 0.002;
         //
    }
}