package com.pawamamama.excption_.try_catch_;

@SuppressWarnings({"all"})
/**
 * @author pawamamama
 * 1.java提供的try和catch块来处理异常
 * 2.try块用于包含可能出错的代码，catch块用于处理try中发生的异常。
 * 3.可以根据需要在程序中有多个try catch块
 */
/**
 * 注意事项
 * 1.如果异常发生了，则异常发生后面的代码不会执行，直接进入到catch块，
 * 2.如果异常没有发生，则顺序执行try代码块，不会进入到catch
 * 3.如果希望不管是否发生异常，都执行某段代码，(比如关闭连接释放资源)则使用-finally{//释放代码} 异常处理机制
 * 4.可以有多个catch语句，捕获不同的异常，进行不同的业务处理，要求父类异常在后，子类异常在前
 *   比如 exception 在后 NullPointerException在前，如果发生异常，只会匹配一个catch
 * 5.可以直接进行try-finally 配合使用，相当于没有捕获异常程序直接绷掉 fin会进行一个善后处理(比如关闭连接释放资源)
 *   如果没有崩掉finally也会去一定去干一些事情
 *
 *
 //try-catch-finally 执行顺序
 * 1.如果catch和finally同时有return语句优先执行finall的return语句
 * 2.如果catch里return那行有计算那就计算之后在去finally的return 返回
 *   相当于阻塞了catch的数值2返回但是语句还是会执行（被暂存）
 * 3.如果return 在 catch 里 finally 没有return
 *   catch语句的return 返回的值会被临时保存成新的变量然后finally干什么都不影响catch 最后返回
 *   但是返回值是对象finally中修改会受影响
 *
 * 1.如果没有出现异常，则执行try中所有语句，不执行catch块中语句，如果有finally，最后还需要执行finally里面的语句
 * 2.如果出现异常try块中异常发生后，try剩下的语句不再执行，执行cuttch块中的语句
 *   如果有finally，最后还需要执行finally里面的语句。
 *
 */
public class TryCatchDetail {
    public static void main(String[] args) {
        //示例
        //我认为这里有问题,我直接用try-catch包住
        String str = "123";
        try {
            int a = Integer.parseInt(str);//把字符串转换成Number
            System.out.println("str = "+a);
        } catch (NumberFormatException e) {//创建了一个数字格式异常的对象e
            // 抓住了这个抛出的NumberFormatException信息
            System.out.println("异常信息" +e.getMessage());
        } finally {//始终要执行的,我这里选择把这个str 置成默认值,等待下一次输出。
            str = "";//
        }
        System.out.println("程序继续执行 str = "+str);
    }
}
