package com.pawamamama.wrapper.bignum;

import java.math.BigDecimal;

/**
 * BigDecimal_ 大数处理方案
 * <pre>
 *     1.我们需要保存一个精度很高的数的时候使用 BigDecimal
 .     2.对BigInteger进行加减乘除
 *          需要使用相应的方法，不能直接进行加减
 *          调用方法加减完之后不会改变原数值
 *             需要新引用指向方法
 *              3.1 加
 *                  3.1.1 BigDecimal.add()
 *                  3.1.2 可以创建一个 要操作的 BigDecimal 然后进行操作
 *                  3.1.3 还可以自己加自己
 *              3.2 减
 *              3.3 乘
 *              3.4 除
 *                  3.4.1 可能会抛出异常，小数除法有可能除不尽，因为BigDecimal精度极高
 *                      ArithmeticException 可能是一个无限循环小数
 *                          解决方法：在方法后面指定精度 BigDecimal.ROUND_CEILING
 *
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/11
 */
public class BigDecimal_ {
     public static void main(String[] args) {
        double d = 1.00000000000000000000000000000000000;
        BigDecimal bigDecimal = new BigDecimal("1.000000000000000000000000000000000000000000000000" +
                "000000000000000000000000000000000000000000000000000000000");
         System.out.println(bigDecimal);
         //加
         BigDecimal bigDecimal1 = new BigDecimal("1.1");
         BigDecimal add =  bigDecimal.add(bigDecimal1);
         System.out.println(add);
         //除
         //BigDecimal divide =  bigDecimal.divide(bigDecimal1);
         BigDecimal divide =  bigDecimal.divide(bigDecimal1,BigDecimal.ROUND_CEILING);

     }
}