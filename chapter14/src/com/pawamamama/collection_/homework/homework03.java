package com.pawamamama.collection_.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * Class: homework03
 *
 * <pre>
 * 作业说明：
 * 本练习主要考察 Map 的基本操作与三种遍历方式
 *
 * 涉及知识点：
 * 1. Map 的 put / 修改 value
 * 2. entrySet() 遍历（重点：视图操作）
 * 3. keySet() 遍历所有 key
 * 4. values() 遍历所有 value
 *
 * 核心理解：
 * entrySet 返回的是 Map 的“视图”，可以直接修改 value
 * </pre>
 *
 * @author pawamamama
 * @date 2026/6/30
 */
@SuppressWarnings({"all"})
public class homework03 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("jack",650);
        map.put("tom",1200);
        map.put("smithf",2999);
        //将jack 工资更改为2600;
        map.put("jack",2600);
        //所有员工加薪100元
        Set set = map.entrySet();
        for (Object o : set) {
          Map.Entry entry =  ((Map.Entry)o);
          Integer newPrice = 100 + (Integer) entry.getValue();//包装类
          entry.setValue(newPrice);
          //entry.setValue((Integer) entry.getValue() +100)//或者写成一条
          System.out.println("员工" +entry.getKey() + "加薪后 ="+entry.getValue()+"元");
        }
        //遍历所有员工
        for (Object key : map.keySet()) {
            System.out.println(key);
        }
        //遍历所有工资
        for (Object value : map.values()) {
            System.out.println(value);
        }
        //员工 + 工资
        for (Object o : map.entrySet()) {
            Map.Entry entry =  ((Map.Entry)o);
            System.out.println(entry.getKey() +" : "+ entry.getValue());

        }


    }
}