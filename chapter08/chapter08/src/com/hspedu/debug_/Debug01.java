package com.hspedu.debug_;

public class Debug01 {
    static void main() {
        //
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res+=i;
            System.out.println("i = "+ i);
            System.out.println("res = "+ res);
        }
        System.out.println("和" +res);
    }
}
