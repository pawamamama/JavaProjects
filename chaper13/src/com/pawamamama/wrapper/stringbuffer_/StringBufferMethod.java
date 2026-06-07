package com.pawamamama.wrapper.stringbuffer_;

/**
 * StringBufferMethod 常用方法和 StringBuffer 的 toString() 使用缓存机制
 * <pre>
 *  第一次调用 toString():
 *      value[] -> 复制到 toStringCache
 *
 *  后续调用 toString():
 *      直接复用 toStringCache
 *
 *  append()、insert()、delete() 等修改操作:
 *      toStringCache = null
 *
 *  下次调用 toString():
 *      重新生成缓存
 *
 *  核心流程:
 *      修改数据 -> 缓存失效
 *      调用toString -> 重建缓存
 *      再次toString -> 使用缓存
 *
 *  本质:
 *      使用 char[] 缓存减少重复复制，
 *      属于典型的缓存失效(Cache Invalidation)设计。
 *
 *
 *  <P>注意事项</P>
 *      StringBuffer的-增-删-改-查-插入
 *      1.下标从零开始的
 *
 *      2.删除和替换是前闭区间后开 [start,end)
 *        删除 替换 为 >=start && <end 处的字符
 *
 *
 *      3插入 offest 的位置向后插入字符串 从一开始
 *       "hello" 插入 " word"  offest =  5
 *       效果为"hello word"
 * </pre>
 *
 * @author pawamamama
 * @since 2026/6/7
 */

public class StringBufferMethod {
    public static void main(String[] args) {
        //1.增
        StringBuffer stringBuffer = new StringBuffer("hello");
        stringBuffer.append("world");
        stringBuffer.append("!").append(100).append(true).append(10.5);
        System.out.println(stringBuffer.toString());
        //2.删
        stringBuffer.delete(5,10);//word 前闭后开
        stringBuffer.delete(6,9);
        System.out.println(stringBuffer.toString());
        //3.改 替换
        stringBuffer.replace(5,6,"?");
        System.out.println(stringBuffer.toString());
        //4.查找
        //查找指定的字符串，在StringBuffer中第一此出现的索引，如果找不到返回-1
        int indexOf = stringBuffer.indexOf("?");
        System.out.println(indexOf);
        //5.插入
        stringBuffer.insert(5," world");
        System.out.println(stringBuffer.toString());
        //6.长度
        System.out.println(stringBuffer.length());
    }
}