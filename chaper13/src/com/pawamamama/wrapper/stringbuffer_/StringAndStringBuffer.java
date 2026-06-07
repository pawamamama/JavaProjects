package com.pawamamama.wrapper.stringbuffer_;

 /**
 * StringAndStringBuffer 之间的相互转换
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/7
 */
public class StringAndStringBuffer {
    public static   void append(String str){
        //String --> StringBuffer
        String s = "hello";
        //方式一
        StringBuffer sb = new StringBuffer(s);//对String本身没有影响
        //方式二
        StringBuffer sb2 = new StringBuffer();
        sb2.append(s);//通过append追加

        //StringBuffer --> String
        //方式一 toString
        StringBuffer sb3 = new StringBuffer("wangweixin");
        String string = sb3.toString();
        //方式二 构造器
        String s1 = new String(sb);


    }
}