package com.pawamamama.annotation;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings({"all"})
/**
 * @author pawamamama
 */
/**
 * @SuppressWarnings 用于抑制（不显示）编译器警告信息
 *
 * 常用参数：
 *
 * "all"
 *      抑制所有警告
 *
 * "unchecked"
 *      抑制未检查的类型转换警告
 *      例如：List list = new ArrayList();
 *
 * "rawtypes"
 *      抑制使用原生类型（Raw Type）警告
 *      例如：List list = new ArrayList();
 *
 * "deprecation"
 *      抑制使用已过时(@Deprecated)成员的警告
 *
 * "unused"
 *      抑制未使用变量、方法、参数的警告
 *
 * "serial"
 *      抑制序列化类未定义 serialVersionUID 的警告
 *
 * "fallthrough"
 *      抑制 switch-case 穿透警告
 *
 * "finally"
 *      抑制 finally 语句相关警告
 *
 * "cast"
 *      抑制不必要的类型转换警告
 *
 * "path"
 *      抑制类路径(classpath)相关警告
 *
 * 使用方式：
 */

//1.当我们不希望看到警告的时候，可以使用 SuppressWarnings注解来抑制警告信息
//3.关于SuppressWarnings的作用范围是和你的放置的位置相关  通常可以放在语句方法类里面
public class SuppressWarnings_ {
    //{""} 中，可以写入你希望抑制（不显示）警告信息
    @SuppressWarnings({"rawtypes","unchecked","unused","all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Hello");
        list.add("World");

    }
}
