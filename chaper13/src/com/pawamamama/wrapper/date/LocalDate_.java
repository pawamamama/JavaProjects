package com.pawamamama.wrapper.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * LocalDate、LocalTime、LocalDateTime 使用演示
 *
 * <pre>
 * JDK8 引入了新的日期时间 API，用于替代 Date 和 Calendar。
 *
 * 主要特点：
 *     1. 不可变对象（Immutable），线程安全。
 *     2. API 设计更加清晰，易于理解和使用。
 *     3. 提供丰富的日期时间计算功能。
 *     4. 解决了 Date 和 Calendar 的设计缺陷。
 *
 * 常用日期时间类：
 *     LocalDate
 *         - 仅表示日期（年、月、日）
 *         - 示例：2026-06-11
 *
 *     LocalTime
 *         - 仅表示时间（时、分、秒、纳秒）
 *         - 示例：23:30:15
 *
 *     LocalDateTime
 *         - 同时表示日期和时间
 *         - 示例：2026-06-11T23:30:15
 *
 * 本类演示内容：
 *     1. 获取当前日期时间对象
 *     2. 获取年、月、日、时、分、秒等字段
 *     3. LocalDateTime 转换为 LocalDate
 *     4. LocalDateTime 转换为 LocalTime
 *
 * 常用方法：
 *     now()             获取当前日期时间
 *     getYear()         获取年份
 *     getMonthValue()   获取月份数字（1~12）
 *     getMonth()        获取月份枚举值
 *     getDayOfMonth()   获取当月第几天
 *     getHour()         获取小时
 *     getMinute()       获取分钟
 *     getSecond()       获取秒
 *     toLocalDate()     转换为 LocalDate
 *     toLocalTime()     转换为 LocalTime
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/11
 */
public class LocalDate_ {
    public static void main(String[] args) {
        //第三代日期
        //1.now 方法直接返回表示当前日期时间的对象 ,一般来讲用LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        System.out.println(LocalDateTime.now());
        // 2. 获取相应数值
        System.out.println("年：" + now.getYear());
        System.out.println("月：" + now.getMonthValue());//数字月份。
        System.out.println("月：" + now.getMonth());//英文月份
        System.out.println("日：" + now.getDayOfMonth());

        System.out.println("时：" + now.getHour());
        System.out.println("分：" + now.getMinute());
        System.out.println("秒：" + now.getSecond());
        //只关心日期或者时间用LocalDate.now() 和 LocalTime.now()
        LocalDate localDate = now.toLocalDate();
        System.out.println(localDate);
        LocalTime localTime = now.toLocalTime();
        System.out.println(localTime);
    }

}
class DateTimeFormatter_ {
    public static void main(String[] args) {
        //格式化日期类
        //DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");规定格式MM 数字月份 HH 0-23
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
        //放入一个三代日期对象进行格式化之后format返回一个String
       String dtf =  dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(dtf);

    }
}
class Instant_ {
    /*时间戳
        类似Date 提供了一系列和Date类转换的方式
    */
    public static void main(String[] args) {
        //Instant 时间戳
        Instant instant = Instant.now();
        System.out.println(instant);
        //转换
        //Instant --> Date
        Date date = Date.from(instant);
        //Date --> Instant
        Instant instant2 = date.toInstant();

    }
}