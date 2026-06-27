package com.pawamamama.collection_.map_.hashmap;

import java.util.HashMap;

/**
 * Class: HashMapSource2
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/26
 */
@SuppressWarnings({"all"})
public class HashMapSource2 {
    public static void  main(String[] args){
        HashMap map = new HashMap();
        for (int i = 1; i <= 12 ; i++) {
            map.put(new A(i), "pawa");
        }
        System.out.println(map);//12个k-v而且在一个桶中
    }
}
class A {
    public int value;

    public A(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return "\nA{" +
                "value=" + value +
                '}';
    }
}