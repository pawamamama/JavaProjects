package com.pawamamama.wrapper.stringbuffer_.stringbuffer_exercise;

/**
 * StringBufferExercise 练习题
 * <pre>
 *     1.关于append方法追加引用为null的String对象的情况
*          String为null的话添加四个容量拼接null
 *
 *
 *
 *     2.关于给StringBuffer有参（String str）构造器一个null值的情况
*          直接空指针异常
 *
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/7
 */
public class StringBufferExercise {
public  static void main(String[] args) {
    //测试题1
    String str = null;
    //这里编译器不检查为空但是，有黄色警告，也没有异常
    StringBuffer stringBuffer1 = new StringBuffer("pawa").append(str);
    //String为null的话添加四个容量拼接null
    //底层调用StringBuffer父类append方法为null直接找appendNull();添加四个容量拼接null
    //输出pawanull
    System.out.println(stringBuffer1.toString());
    //测试题2
    //感觉报错 父类构造器有 str.length 但是运行时为null 直接报异常 NullPointerException
    //空指针异常
    StringBuffer stringBuffer = new StringBuffer(str);
}
}