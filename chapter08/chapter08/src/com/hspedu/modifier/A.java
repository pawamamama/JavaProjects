package com.hspedu.modifier;
/*
Java 四种访问修饰符（Access Modifier）

1. public（公共的）
   - 权限最大
   - 同一个类、同一个包、不同包都可以访问
   - 常用于对外提供的方法和类

2. protected（受保护的）
   - 同一个类、同一个包可以访问
   - 不同包中的子类也可以访问
   - 常用于继承时给子类使用

3. 默认/default（不写修饰符）
   - 也叫包访问权限（package-private）
   - 只能在同一个包中访问
   - 不同包无法访问

4. private（私有的）
   - 权限最小
   - 只能在当前类内部访问
   - 常用于封装成员变量

--------------------------------------------------

访问范围总结：

                当前类    同包    子类    不同包
public            √       √      √        √
protected         √       √      √        ×
default           √       √      ×        ×
private           √       ×      ×        ×

--------------------------------------------------

示例：

public class Test {

    public int a = 1;      // 所有人可访问
    protected int b = 2;   // 同包和子类可访问
    int c = 3;             // 默认权限，仅同包可访问
    private int d = 4;     // 仅当前类可访问
}
*/// no usages 没有任何引用
 public class A {
    //四种访问修饰符
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;
    public void m() {
        //该方法可以访问 四个属性 (同类访问)
        System.out.println("  public n1 = "+n1 + "  protected n2 = " +
                n2 +"  默认 int n3 = "+ n3 +"  private n4 = " + n4);
    }
    //修饰符可以用来修饰类中的属性、成员方法、以及类
    //成员方法的访问规则和属性完全一样
    protected void m2() {

    }
     void m3() {

    }
     private void m4() {

    }

}
//只有默认的和public才能修饰类
class A1 {

}

