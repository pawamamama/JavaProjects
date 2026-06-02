package com.pawamamama.final_;

public class Final01 {
}
//final修饰类，不希望这个类被继承
final class A {

}
class B {
    //不希望父类的某个方法被子类覆盖/重写override
     public final void  ok(){

    }
}
class C extends B {

  /*  public void ok() {

    }*/
}
class D   {
    //不希望某个属性的值被修改，可以用final
    //常量
    public final double TAX_RATE = 0.08;
//不希望某个局部常量被修改，可以用final修饰
    public void ol() {
      //这时，NUM 也被称之为 局部常量
        final int NUM = 10;
    }

}