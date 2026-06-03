package com.pawamamama.excption_.CustomExcetion;

/**
 * @author pawamamama
 * 接收person对象年龄时，要求范围在18到120之间，否则抛出一个自定义异常(要求继承RuntimeException)
 * 1.throws 在声明处 throw 在方法体创建异常对象
 * 2.try-finally   try生成了异常要暂时阻塞生成，执行finally之后才能抛出异常
 *
 */
public class 自定义异常 {
    public static void main(String[] args) {
        int age = 80;
        if (!(age >= 18 && age <= 120)) {
            throw new AgeException("年龄需要在 18~120之间");
        }
    }
}

//自定义异常
//1.一般情况下，我们的自定义异常继承运行时异常RuntimeException
//好处是我们可以使用默认的处理机制
class AgeException extends RuntimeException {
    public AgeException(String message) {//构造器
        super(message);
    }
}