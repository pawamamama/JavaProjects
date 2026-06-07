package com.pawamamama.wrapper.string_.string_method;

/**
 * StringCommonMethods02 Stting常用方法02
 *
 * @author pawamamama
 * @since 2026/6/6
 */
public class StringCommonMethods02 {
    public static void main(String[] args) {
        String s1 = "pawa";
        //toUpperCase()转成大写
        System.out.println(s1.toUpperCase());//PAWA
        String s2 = "PAWA";
        //toLowerCase()转成小写
        System.out.println(s1.toLowerCase());//pawa
        //2. concat 拼接字符串
        s1 = s1.concat("ma").concat("mama");
        System.out.println(s1);
        //4. replace 替换字符串中的字符
        String s3 = "pawamamama and 吴俊希是sbsbsbsb";
        String s4 = s3.replace("sb", "牛逼");// 将所有的sb替换成牛逼
        System.out.println(s4);
        System.out.println(s3);//注意：如果不让s3引用指向s3.replace，则不修改原数值
        //5. split 分割字符串 ，对于某些分割字符，我们需要转义字符 | \\
        String ppem = "锄禾日当午,汗滴禾下土,谁知盘中餐,粒粒皆辛苦";
        //以逗号进行分割，有几个就分割成几个字符串
        String[] split = ppem.split(",");
        //没有逗号
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        //文件夹分割特别说明 对于某些分割字符，我们需要转义 \\等
        String poeem = "D:\\aaa\\bbb";
        String[] mama = poeem.split("\\\\");//要以这种形式相当于转译字符的转义字符才能找到
        for (int i = 0; i < mama.length; i++) {
            System.out.println(mama[i]);
        }
        //6.toCharArray 转换成字符数组
        char[] chs = ppem.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            System.out.println(chs[i]);
        }
        //7.compareTo 比较两个字符串的大小，前者大就返回整数 后者大就返回负数
        //
        String s5 = "jack";
        String s6 = "jchn";
        System.out.println(s5.compareTo(s6));
        //如果在代码中发现了不一样的话  return c1 - c2; 根据7.来算
        // 代码 return len1 - len2;发现数值相等或者字符串大小不一样但是小的那个字符串儿
        //是 jck 和jack 那就返回 jac长度 -jack的长度 = -1


        //format 格式字符串 类c输出
        String name = "john";
        int age = 10;
        double score = 10.0;
        char gender = '男';
        String info = String.format("的姓名是 %s 年龄是 %d 成绩是 %.2f 性别是 %c", name, age, score, gender);

        System.out.println(info);
}
}