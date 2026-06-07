package com.pawamamama.wrapper;

/**
 * @author pawamamama
 */

public class WrapperExercise02
{
    public  static void main(String[] args)
    {
        // Integer.valueOf() 会使用 IntegerCache 缓存池
        // -128~127 之间不会创建新对象，而是返回缓存数组中的 Integer 对象引用
        // 例如 Integer.valueOf(1) 返回 cache[129] 中保存的 Integer(1) 对象
        // 因此 Integer m = 1; Integer n = 1; 时，m 和 n 指向同一个对象，m == n 为 true
        Integer m =1;
        Integer n = 1;
        System.out.println(m == n);

        Integer m1 = 128;
        Integer n1 = 128;//底层是 Integer.valueOf(int)方法
        System.out.println(m1 == n1);
        //包装类 == 基本数据类型对比数值
        Integer m2 = 100;
        int n2 = 100;
        System.out.println(m2 == n2);//true
        //false false true false false true true
        System.out.println(m2.toString());
    }
}
