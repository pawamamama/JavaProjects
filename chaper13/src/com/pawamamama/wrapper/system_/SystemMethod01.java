package com.pawamamama.wrapper.system_;

import java.util.Arrays;

/**
 * SystemMethod01
 * <pre>
 *     常见方法
 *         1. exit 退出当前程序
 *              1.1 System.exit(0)
 *                  1.1.1  0代表正常退出
 *         2. arraycopy 复制数组元素比较适合底层调用，一般使用Arrays.copyOf 完成复制数组
 *         arraycopy(Object src,  int  srcPos,Object dest, int destPos,int length);
 *              底层的形参说明：
 *                  - src：源数组
 *                  - srcPos：源数组的起始位置
 *                  - dest：目标数组
 *                  - destPos：目标数组的起始位置
 *                  - length：要复制的数组元素个数
 *              arraycopy 当要复制的元素大于new数组的容量时，会数组索引越界异常
 *         3. currentTimeMiens 返回当前时间距离1970-1-1 的毫秒数
 *         4. System.gc() 运行gc垃圾回收机制 ,已弃用
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/10
 */
public class SystemMethod01 {
    public static void main(String[] args) {
        //exit
        System.out.println("-====");
        //System.exit(0);
        System.out.println("-====");
        //System.arraycopy
        int[] src = {1, 2, 3, 4, 5};
        int[] newsSrc = new int[src.length + 1];
        System.arraycopy(src, 0, newsSrc, 1, src.length);
        System.out.println(Arrays.toString(newsSrc));
        //currentTimeMiens
        System.out.println(System.currentTimeMillis());
    }
}