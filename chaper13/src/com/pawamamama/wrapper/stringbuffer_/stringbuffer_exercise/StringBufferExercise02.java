package com.pawamamama.wrapper.stringbuffer_.stringbuffer_exercise;

import java.util.Scanner;

  /**
 * StringBufferExercise02
 * <pre>
 *        //小数点加千分位
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/7
 */
public class StringBufferExercise02 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        //小数点加千分位
        String price = "1234564.101";
        StringBuffer buffer = new StringBuffer(price);

        for ( int i = buffer.lastIndexOf(".") - 3; i>0;i -=3) {
           buffer = buffer.insert(i,",");
        }
        System.out.println(buffer);
    }

}