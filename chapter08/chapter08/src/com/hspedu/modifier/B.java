package com.hspedu.modifier;

public class B {
    //访问四个属性
    public void b() {
        A a = new A();
        //在同一个包下可以访问 public protected 默认修饰属性和方法 ，不能访问private属性
        System.out.println("  public n1 = " + a.n1 + "  protected n2 = " + a.n2
                + "  默认 int n3 = " + a.n3 + "  不能访问(私有)private n4");
        //方法
        /*a.m();
        a.m2();
        a.m3();*/
    }

}
