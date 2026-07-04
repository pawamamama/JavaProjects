package com.pawamamama.generic;

/**
 * Class: GenericCustome
 *
 * <pre>
 * 自定义泛型类示例说明：
 *
 * 1. 泛型类基本语法：
 *    class 类名<T, R, ...> {
 *        // T, R 等表示类型占位符，可以在类中任意使用
 *    }
 *
 * 2. 泛型特点：
 *    - 泛型可以有多个类型参数（如 T, R, M）
 *    - 泛型可以用于：属性、方法参数、返回值
 *    - 泛型类型在创建对象时确定
 *
 * 3. 注意事项（重点）：
 *    1) 普通成员可以使用泛型（属性 / 方法）
 *    2) 不能创建泛型数组（如 new T[10] ❌）
 *    3) 静态成员不能使用类泛型（static 方法/属性 ❌ 使用 T）
 *    4) 泛型类型在“对象创建时”确定
 *    5) 如果创建对象时不指定泛型类型，默认是 Object
 *
 * 4. 泛型类本质：
 *    - 编译期类型检查
 *    - 运行期类型擦除（全部变为 Object）
 *
 * 5. 应用场景：
 *    - 通用数据容器（如自定义容器类）
 *    - 多类型数据封装（如 Tuple / Pair / Triple）
 *    - 提高代码复用性与类型安全性
 *
 * 示例结构：
 *    class Tiger<T, R, M> {
 *        T t;
 *        R r;
 *        M m;
 *        String name;
 *    }
 *
 * </pre>
 *
 * @author pawamamama
 * @date 2026/7/4
 */
@SuppressWarnings({"all"})
public class GenericCustome {
    public static void main(String[] args) {
        //T=Double, R=String, M=Integer
        Tiger<Double, String, Integer> g = new Tiger<>("john");
        g.setT(10.9); //OK
        // g.setT("yy"); //错误，类型不对
        System.out.println(g);
        Tiger g2 = new Tiger("john~~");//OK T=Object R=Object M=Object
        g2.setT("yy"); //OK ,因为T=Object "yy"=String 是Object 子类
        System.out.println("g2=" + g2);
    }
}
//1. Tiger 后面泛型，所以我们把Tiger 就称为自定义泛型类
//2, T, R, M 泛型的标识符, 一般是单个大写字母
//3. 泛型标识符可以有多个.
//4. 普通成员可以使用泛型(属性、方法)
//5. 使用泛型的数组，不能初始化
//6. 静态方法中不能使用类的泛型

class Tiger<T, R, M> {

    String name;
    R r;//属性使用到泛型
    M m;
    T t;//ok

    //new 的时候不能确定 T 的类型，无法在内存开辟空间
    //T[] t1 = new T[8]//不行
    Tiger(R r, M m, T t) {//构造器使用泛型（方法）

        this.r = r;
        this.m = m;
        this.t = t;
    }

    public Tiger(String name) {
        this.name = name;
    }

    //方法使用泛型 get and set
    public R getR() {//方法泛型
        return r;//返回值泛型
    }

    public void setR(R r) {
        this.r = r;
    }
    //因为静态是和类相关的，在类加载时，对象还没有创建
    //所以，如果静态方法和静态属性使用了泛型，JVM 就无法完成初始化
    //static  R r;错
   /* public static R f() {错
        return R;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}