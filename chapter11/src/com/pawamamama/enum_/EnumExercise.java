package com.pawamamama.enum_;

/**
 * @author pawamamama
 */
public class EnumExercise {
    public static void main(String[] args) {
        for (Weekday day : Weekday.values()) {
            System.out.println(day);
        }
    }
}

/**
 * 星期枚举类
 */
enum Weekday {

    SUNDAY("星期日"),
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六");

    // 汉语名称
    private String chineseName;

    /**
     * 构造器，枚举的构造器默认是 private
     */
    Weekday(String chineseName) {
        this.chineseName = chineseName;
    }

    /**
     * 获取中文名称
     */
    public String getChineseName() {
        return chineseName;
    }

    /**
     * 重写 toString 方法，打印时输出英文 + 中文
     */
    @Override
    public String toString() {
        return this.name() + " (" + chineseName + ")";
    }
}

