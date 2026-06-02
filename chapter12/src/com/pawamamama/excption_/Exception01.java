package com.pawamamama.excption_;

/**
 * @author pawamamama
 * ArithmeticException 算数异常
 */
public class Exception01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        //1.执行到这里会抛出异常  ArithmeticException 算数异常
        //2.抛出异常后，程序会退出，崩溃了，下面的代码不会输出
        //3.小问题不影响运行，使用异常处理机制提高代码的健壮性
        //int c = a / b;

        //使用try - catch异常处理机制来解决 try 尝试 catch 接住
        //将代码块选中 ctrl + alt + t 使用try - catch
        //4.即使程序出现了异常，程序可以继续运行
        try {
            int c = a / b;//有问题就捕获
        } catch (Exception e) {
            //e.printStackTrace();//捕获后输出信息
            System.out.println(e.getMessage()  );
        }
        System.out.println("然后程序继续运行");

    }
}

