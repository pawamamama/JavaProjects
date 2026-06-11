package com.pawamamama.wrapper.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * oneDate 第一代日期
 * <pre>
 *
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/11
 */
public class oneDate  {
    public static void main(String[] args) throws ParseException {
        Date d1 = new Date();//1.获取当前系统时间
        //2. 这个Date 类在 import java.util.Date 包下
        System.out.println("当前时间是 = " + d1);
        //3.默认输出格式是国外格式，通常需要用SimpleDateFormat进行格式转换
        //4.格式使用的字符是规定好的
        //使用 SimpleDateFormat 规定好格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh：mm：ss：E");
        String sdf = simpleDateFormat.format(d1);//把当前date传入到SimpleDateFormat处理后返回字符串
        System.out.println("转换后的格式" + sdf);
        //可以把一个格式化的字符串转成一个date
        String sdf1 = "1996年01月01日 10：20：30：星期一";//要转换的字符串要和 SimpleDateFormat 规定好格式一样
        Date parse = simpleDateFormat.parse(sdf1);
        System.out.println(parse);
        // 通过毫秒数来得到时间
        Date date = new Date(90909090);
        System.out.println(date);


    }
}