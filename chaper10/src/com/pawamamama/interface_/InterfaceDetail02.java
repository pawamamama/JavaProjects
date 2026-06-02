package com.pawamamama.interface_;
public class InterfaceDetail02 {
    public static void main(String[] args) {
        //用接口的静态方法
        AAA.n2();
        //接口的属性不可修改//pubic  final static
        //abc.a =23;
    }
}
//接口可继承接口
interface vdvd extends AAA,BBB {
    //多接口有共同实现方法，子接口需要重写该方法或者指定访问哪个父接口的使用
    @Override
    default void aa() {
        AAA.super.aa();
    }
}
//接口中的属性，只能是 pubic  final static 的
interface abc {
  public final static   int a = 0;//可省略
}


//一个类同时可以实现多个接口
class CCC implements AAA,BBB{
    //当两个接口中都有同一个default 方法实现类必须重写他
    @Override
    public  void aa() {

    }
    @Override
    public void aaa() {

    }

    @Override
    public void bbb() {

    }
}
interface AAA {
    void aaa();
    //当两个接口有同样要求类实现的方法时不冲突
    void bbb();

    //方法层面（有没有被类继承到方法）
    //两个接口有同样的实现方法时不冲突
    default void aa() {}
    //实例对象可调用
    default void bbbbbb() {}
    //私有的更不可能冲突
    private  int n1(){
        return 0;
    }
    //静态方法 也不冲突
     static  int n2(){
        return 0;
    }
}
interface BBB {
    void bbb();
    default void aa() {}
    private int n1() {
        return 0;
    }
    static int n2() {
        return 0;
    }
}