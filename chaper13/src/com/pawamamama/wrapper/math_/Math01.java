package com.pawamamama.wrapper.math_;

/**
 * Math01 Math类常用方法演示
 * <pre>
 *     1. Math类中的方法大多数为静态方法，可直接通过类名调用
 *     2. 演示常见数学运算方法：
 *          - abs()    : 求绝对值
 *          - pow()    : 求幂运算
 *          - ceil()   : 向上取整
 *          - floor()  : 向下取整
 *          - round()  : 四舍五入
 *          - sqrt()   : 求平方根
 *          - random() : 生成随机数
 *
 *     3. 生成区间随机整数公式：
 *          (int)(a + Math.random() * (b - a + 1))
 *        可得到 [a,b] 范围内的随机整数
 *
 *        例如：
 *          (int)(2 + Math.random() * 6)
 *        得到 2~7 之间的随机整数
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/8
 */
public class Math01 {
    public static void main(String[] args) {
        //abs 绝对值
        int abs = Math.abs(100);
        System.out.println(abs);
        //pow 求幂
        double pow = Math.pow(111.1,4);
        System.out.println(pow);
        // ceil 向上取整 ，返回>=该参数的最小整数
        double ceil = Math.ceil(-444.0001);//-444.0
        System.out.println(ceil);
        //floor 向下取整，返回<=该参数的最大整数
        double floor = Math.floor(444.0009);//444
        System.out.println(floor);
        //round 四舍五入
        // 0.5时+0.5
        System.out.println(Math.round(444.500));
        //小于0.5时/
        double round = Math.round(444.4999);//445
        System.out.println(round);
        //sqrt 求开方
        double sqrt = Math.sqrt(9);
        System.out.println(sqrt);
        //random 求随机数
        //a-b之间的的整数 2-7
        // Math.random()*  6 返回的时 0 <= x < 6 的小数
        //2 + Math.random()*  6 返回的是 0+2 <= x < 8 的小数
        //直接 (int)  就是 2-7范围间的小数
        System.out.println(Math.random());
        for (int i = 0; i < 100; i++) {
            int 随机数 = (int)(2 + Math.random()*  6);
            System.out.println(随机数);
        }




    }
}