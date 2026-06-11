package com.pawamamama.wrapper.bignum;

import java.math.BigInteger;

/**
 * BigInteger_大数处理方案
 * <pre>
 *     1.解决long 存不进去的值,但该值实际存在，使用 BigInteger来存取
 *     2.初始化 BigInteger
 *          2.1 new BigInteger("这里填数字")，用字符串引起来
 *     3.对BigInteger进行加减乘除
 *          需要使用相应的方法，不能直接进行加减
 *          调用方法加减完之后不会改变原数值
 *              需要新引用指向方法
 *              3.1 加
 *                  3.1.1 bigInteger.add()
 *                  3.1.2 可以创建一个 要操作的 BigInteger 然后进行操作
 *                  3.1.3 还可以自己加自己
 *              3.2 减
 *                  3.2.1
 *              3.3 乘
 *              3.4 除
 *
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/10
 */
public class BigInteger_ {
    public static void main(String[] args) {
        long l = 1010101010101010l;
        System.out.println(l);
        BigInteger  bigInteger = new BigInteger("1000000000000000000000000");
        //3.1 add
            //3.1.2
            BigInteger bigInteger1 = new BigInteger("100");
            BigInteger add = bigInteger.add(bigInteger1);
            System.out.println(add);
            //3.1.3
            add = bigInteger.add(bigInteger);
            System.out.println(add);
        //3.2 subtract
            BigInteger subtract =  bigInteger.subtract(bigInteger1);
            System.out.println(subtract);
        //3.3 multiply
            BigInteger multiply =  bigInteger.multiply(bigInteger1);
            System.out.println(multiply);
        //3.4 divide
        BigInteger divide =  bigInteger.divide(bigInteger1);
        System.out.println(divide);


    }
}