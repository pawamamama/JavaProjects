package com.pawamamama.wrapper.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;

/**
 * LocalDate_Method
 * <p>
 * 演示Java 8日期时间API中常用方法：
 * <ul>
 *     <li>LocalDateTime类的获取当前时间</li>
 *     <li>MonthDay类检查重复事件（如生日）</li>
 *     <li>判断是否为闰年</li>
 *     <li>增加日期的某个部分（年、月、日）</li>
 *     <li>使用plus方法增加时间（小时、分钟、秒）</li>
 *     <li>使用minus方法查看一年前、一年后的日期</li>
 * </ul>
 * </p>
 *
 * @author pawamamama
 * @since 2026/6/12
 */
public class LocalDate_Method {
    public static void main(String[] args) {

        // 1. LocalDateTime类
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);

        // 2. MonthDay类：检查重复事件（生日）
        MonthDay birthday = MonthDay.of(11, 1); // 11月1日
        MonthDay today = MonthDay.from(LocalDate.now());

        if (birthday.equals(today)) {
            System.out.println("今天是生日！");
        } else {
            System.out.println("今天不是生日");
        }

        // 3. 判断是否为闰年
        LocalDate date = LocalDate.now();
        System.out.println(date.getYear() + " 是否闰年："
                + date.isLeapYear());

        // 4. 增加日期的某个部分
        System.out.println("增加1年：" + date.plusYears(1));
        System.out.println("增加2个月：" + date.plusMonths(2));
        System.out.println("增加10天：" + date.plusDays(10));

        // 5. 使用plus方法增加时间
        System.out.println("增加3小时："
                + now.plusHours(3));

        System.out.println("增加30分钟："
                + now.plusMinutes(30));

        System.out.println("增加15秒："
                + now.plusSeconds(15));

        // 6. 使用minus方法查看一年前和一年后的日期
        System.out.println("一年前："
                + date.minusYears(1));

        System.out.println("一年后："
                + date.plusYears(1));
    }

}