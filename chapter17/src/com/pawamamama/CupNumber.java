package com.pawamamama;

import org.omg.SendingContext.RunTime;

/**
 * Class: CupNumber
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/8
 */
@SuppressWarnings({"all"})
public class CupNumber {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //availableProcessors 可用处理器
        int i = runtime.availableProcessors();
        System.out.println("AvailableProcessors: " + i);
    }

}