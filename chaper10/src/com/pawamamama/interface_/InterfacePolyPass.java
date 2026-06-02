package com.pawamamama.interface_;
/*
* 演示多态传递
*
*
* */
public class InterfacePolyPass {
    public static void main(String[] args) {

        // IJ 接口类型引用
        // 指向 Teacher 对象
        // 因为 Teacher 实现了 IK
        // 而 IK 又继承了 IJ
        // 所以 Teacher 也属于 IJ 类型
        IJ ij = new Teacher();
        //如果要顶级接口要变成中级接口使用使用需要向下转型
         IK ik2   =   (IK)ij;

        // IK 接口类型引用
        // 指向 Teacher 对象
        // Teacher 直接实现了 IK
        IK ik = new Teacher();
        //向上转型
        IJ ij2 = ik;
    }
}
    // 一个接口
    interface IJ {}

    // IK 继承 IJ
// 所以 IK 拥有 IJ 的特征
    interface IK extends IJ {}

    // Teacher 实现 IK
// 由于 IK 继承 IJ
// 所以 Teacher 同时也算实现了 IJ
    class Teacher implements IK {}


