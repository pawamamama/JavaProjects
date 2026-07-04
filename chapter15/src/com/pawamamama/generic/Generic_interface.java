package com.pawamamama.generic;

import java.util.ArrayList;

/**
 * Class: Generic_interface
 *
 * <pre>
 * 自定义泛型接口示例说明：
 *
 * 1. 泛型接口基本语法：
 *    interface 接口名<T, R, ...> {
 *        // 可以定义使用泛型的方法
 *    }
 *
 * 2. 泛型接口特点：
 *    - 接口中可以定义多个类型参数（T, R 等）
 *    - 泛型可以用于方法返回值、参数类型
 *    - 泛型接口的类型在实现接口或使用匿名类时确定
 *
 * 3. 注意事项（重点）：
 *    1) 接口中的静态成员不能使用泛型类型（与泛型类一致）
 *    2) 泛型接口的类型在“实现接口时”确定
 *    3) 如果实现类不指定泛型类型，则默认使用 Object
 *
 * 4. 泛型接口的确定方式：
 *    - 实现接口时指定具体类型：
 *      class A implements Interface<String, Integer>
 *
 *    - 或在创建匿名实现类时指定：
 *      new Interface<String, Integer>() { ... }
 *
 * 5. 本质：
 *    - 泛型接口在编译期做类型检查
 *    - 运行期仍然是类型擦除（Object）
 *
 * 6. 应用场景：
 *    - 数据访问层（DAO / Repository）
 *    - 通用回调接口（Callback）
 *    - 工厂模式返回不同类型对象
 *
 * 示例结构：
 *    interface ITool<T, R> {
 *        R process(T t);
 *    }
 *
 * </pre>
 *
 * @author
 * @date 2026/7/4
 */
@SuppressWarnings({"all"})
public class Generic_interface {
    public static void main(String[] args) {
   new ArrayList<String>();
    }

}
// 2. 泛型接口的类型在“实现接口时”或者实现类时确定

interface IA extends  Usb<String,Double> {

}
//实现时自动把泛型换成IA 继承Usb 时指定的 U = String ：R = Double
class AA implements IA {

    @Override
    public Double get(String s) {
        return 0.0;
    }

    @Override
    public void hi(Double aDouble) {

    }

    @Override
    public void run(Double r1, Double r2, String u1, String u2) {

    }
}
//2. 实现接口时，直接指定泛型接口的类型
//给 U = Integer ：R = Float
class BB implements Usb<Integer,Float> {

    @Override
    public Float get(Integer integer) {
        return 0f;
    }

    @Override
    public void hi(Float aFloat) {

    }

    @Override
    public void run(Float r1, Float r2, Integer u1, Integer u2) {

    }
}
//3. 没有指定类型默认为 Object
// R = Object
// U = Object
//等价于 Usb<Object,Object>
//
class CC implements Usb {

    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void hi(Object o) {

    }

    @Override
    public void run(Object r1, Object r2, Object u1, Object u2) {

    }
}
interface Usb<U, R> {
    //1. 接口中的静态成员不能使用泛型类型（与泛型类一致）
    int N = 1;//ok
    // U name = "pawa" no
    // U pawa; no


    //普通方法中可以使用泛型
    R get(U u);

    void hi(R r);

    void run(R r1, R r2, U u1, U u2);

    //在jdk 8 中，可以在接口中，使用默认方法
    default R method(U u) {
        return null;

    }
}
