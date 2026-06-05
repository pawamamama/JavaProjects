/*
package com.pawamamama.wrapper.string_;

*/
/**
 * @author pawamamama
 * String类的理解和创建对象
 * A.
 * 1.String对象用于保存字符串，也就是一组字符序列
 * 2.字符串常量是 "dfjd" 这样的
 * 3. 字符串的字符使用Unicode 字符编码，一个字符(不区分字母还是汉字)占两个字节
 * 4. String 类有很多构造器，构造器的重载，其他的看手册
 * 5.Stirng类是final类不能被其他类继承
 * 6.String 的  private final char value[];属性是用来存放我们的字符串内容的
 * 7.private final char value[];是一个final类型，一旦赋值不能修改（地址不能修改不是字符不能改）
 * 8.value[]指向了一块空间之后就固定下来了不能再指向另一个的空间了，
 * 9.value[]里面的char值可以修改
 *
 *
 * B.
 * String类的父类是Obj
 * 实现接口
 * 1.String实现了Serializable接口， String可以串行化，对象可以在网络传输
 * 2.String实现了Comparable接口说明String对象可以相互比较
 * 3.String实现了CharSequence字符序列接口
 *//*

public class String01 {
    public static void main(String[] args) {
        //A.1

        String name = "jack";//A.2字符串常量
        name = "tom";
        //A.3
        //
        //常用的构造器
        */
/*String s1 = new String();
        String s2 = new String(String original);
        String s3 = new String( char[] a);
        String s4 =  new String( char[] a , int startIndex, int count)
        String s5 = new String( byte[] b)*//*

        //A.6~A.9
        final char[] value ={'a','b','c'};
        final char[] value2 = {'a','b','c'};
        //有final情况下不允许
        //value = value2;
        //引用私有化 引用地址一对一
        //但是char[] value 是可以接收一个final char[]的地址的 引用赋值
        value2[2] = 'q';

        for (char c : value) {
            System.out.println(c);
        }
    }
}
*/
