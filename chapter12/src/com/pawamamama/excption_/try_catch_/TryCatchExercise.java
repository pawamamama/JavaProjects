package com.pawamamama.excption_.try_catch_;

import java.util.Scanner;

/**
 * @author pawamamama
 * 如果用户输入的不是一个整数，就提示它反复输入，直到输入一个整数为止。
 */
public class TryCatchExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Input ="";
        int num = 0 ;
        boolean   keep = true;
        while (/*keep*/true) {
            try {
                Input = scanner.next();
                num =  Integer.parseInt(Input);
                //keep = false;//到这里就说明没有异常
                break;//更好的方案
            } catch (NumberFormatException e) {//数字异常
                System.out.println("输入的数组有误重新输入");
            }/*finally {
                if (!keep) {
                    break;
                }
            }*/
        }
        System.out.println("输入的数字是" + num);
    }
}
