package com.pawamamama.wrapper.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Calendar_ 第二代日期
 * <pre>
 *     Calendar 日历
 *            1. Calendar类是一个抽象类 ，他为特定瞬间的一组 YEAR MONTH DAY_OF_MONTH HOUR 、
 *               等 日历字段之间的转换提供了一些方法，并为操作日历字段（例如，获得下星期的日期）提供了一些方法
 *            2. 构造器私有化 可以通过gitINstance() 来获取实例
 *            3.还提供了大量的方法和字段提供给程序员
 *            4. Calendar 把时间和日期藏到了字段中，使用时直接使用
 *            5.使用Calendar对象获取时间日期信息
 *              Calendar实例对象.get(你想获取的类名.字段名);
 *            6.更简洁的方式使用 SimpleDateFormat 格式化
 *              SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
 *               sdf.format(calendar.getTime())
 *            7.也可以自己组合
 *            8.12小时制 Calendar.HOUR
 *              24小时制 Calendar.HOUR_OF_DAY
 *
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/11
 */
public class Calendar_ {
    public static   void  main(String []args){
        //使用 get方法来获取一个Calendar对象
        Calendar calendar = Calendar.getInstance();
        //查看格式
        System.out.println(calendar);
        //获取时间日期然后组合
        System.out.println(
                "年: " + calendar.get(Calendar.YEAR) +
                        " 月: " + (calendar.get(Calendar.MONTH) + 1) +
                        //月从零开始计算的，想要获取正确的要加1
                        //返回月的时候是按照零开始编号的
                        " 日: " + calendar.get(Calendar.DAY_OF_MONTH) +
                        " 时: " + calendar.get(Calendar.HOUR_OF_DAY) +   // 24小时制
                        " 分: " + calendar.get(Calendar.MINUTE) +
                        " 秒: " + calendar.get(Calendar.SECOND)
        );
        //更简洁的方式使用 SimpleDateFormat 格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(sdf.format(calendar.getTime()));
    }


}