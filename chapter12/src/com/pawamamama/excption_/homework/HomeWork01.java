package com.pawamamama.excption_.homework;

/**
 * @author pawamamama
 */
public class HomeWork01 {
    public static void main(String[] args) {


        try {
            //先验证输入的参数是否正确
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            //先把接收到的参数转换成整数
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            double res = EcmDef.cal(n1, n2);//该方法可能抛出算术异常
            System.out.println("计算结果是  " + res);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("参数格式不正确");
        } catch (ArithmeticException e) {
            System.out.println("出现了除以0的异常");
        }

    }
}

class EcmDef {
    public static int cal(int n1, int n2) {
        return n1 / n2;
    }
}