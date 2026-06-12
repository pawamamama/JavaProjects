package com.pawamamama.hoemwork_;
/**
 * HomeWork01
 * <p>
 * 该类演示了如何反转字符串中指定范围的字符。
 * 主要功能：
 * <ul>
 *     <li>输入字符串不可变，先转换为 char[] 数组</li>
 *     <li>对 start 到 end 范围内的字符进行反转</li>
 *     <li>使用双指针方式，避免额外计算循环次数</li>
 *     <li>参数校验，非法输入抛出 RuntimeException</li>
 * </ul>
 * </p>
 *
 * @author pawamamama
 * @since 2026/6/12
 */
public class HomeWork01 {
    public static void main(String[] args) {
        String str = "0123456789";
        String newStr = null;
        try {
            newStr = reverse(str, 0,9);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        System.out.println(newStr);
    }

    //思路分析
    //1.String一个不可变序列，先转成char []
    public static String reverse(String str, int start, int end) {
        //数值校验
        //正确的然后取反
        //只要有一个不正确 !(false) = true 报异常
       if (!(str != null && start >=0 && end > start && end < str.length())) {
           throw new RuntimeException("参数不正确");
       }

        //1.转换成 char[]
        char[] arr = str.toCharArray();
        //计算循环次数
        //得到(start到end有多少元素)/2就是要交换的次数
        //如果是奇数直接舍弃小数 最后一次就是  a b a
        //b直接不用交换
            //两个 int 相除，结果仍然是 int，小数部分直接舍弃（截断）
      /*  int count = (end-start + 1)/2;
        char tmp ;
        for (int i = 0, start1 = start, end1 = end; i < count; i++, start1++, end1--) {
            //交换
            tmp = arr[start1];
            arr[start1] = arr[end1];
            arr[end1] = tmp;
        }*/
        //更简单的写法
        //思路就是 类似两个人走路离得越来越近了 i==j时说明都翻转好了直接false不执行了
        for (int i = start,j = end ; i<j  ; i++,j--) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

       //return new String(arr);
        return  String.valueOf(arr);
    }

}