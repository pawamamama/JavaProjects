package com.pawamamama.excption_;

/**
 * @author pawamamama
 */
@SuppressWarnings({"all"})
public class 异常处理机制 {
    public static void main(String[] args) {//这里有默认的throws方法
        // 1.try-catch-finally 异常处理机制
        //尝试-捕获-最终执行
        try {
            //这里要是没有加try-catch-finally处理这个异常默认就由throws方法将这个异常丢给Object
            int i = 10/0;
            //代码/可能有异常
        } catch (Exception e) {
            //捕获到异常
            //1.异常发生时
            //2.系统将异常封装成Exception 对象e,传递给catchfd块
            //3.这个抛出的异常对象e由程序员处理，想怎么处理怎么处理（控制权交给程序员）
            //4.没有发生异常catch块不会执行
        } finally {
            //1.不管try代码块是否有异常发生，始终执行finally
            //2.所以通常将释放资源行为放在finall保证一定会关闭
        }
    }
    //二  throws处理机制
    //1.throws 只是“声明”
    //2.throws处理机制遇到异常返回到调用这个方法的上级方法
    //3.要是这个上级方法 没有使用 catch处理 就一直到Object类
    //4.到Ojbect的时候jvm处理方式一般是终止程序然后抛出异常信息，简单暴力
    // 告诉调用者：这个方法可能会抛出异常，但我不处理
    public static void test() throws Exception {

        System.out.println("方法开始执行");

        // 2. 这里真正“抛出异常”
        // 一旦执行 throw，方法立即终止
        throw new Exception("这里发生错误");

        // 这一行永远不会执行（已被中断）
        // System.out.println("方法结束");
    }
}
