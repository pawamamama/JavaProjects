package com.pawamamama.chapter10Homerork;

/**
 * @author pawamamama
 */
public class HomeWork01 {
    public static void main(String[] args) {
   /*     for (Color c : Color.values()) {
            System.out.println(c.show());
        }
        System.out.println(Color.RED.show());*/
        //枚举值相当于常量对象可以被switch使用
        //switch放入枚举对象
        //case后，直接写上enum规定的枚举值
        //底层是按照enum序号比对的
        Color c = Color.RED;
        switch (c) {
            case RED:
                System.out.println(c.show());
                break;
                case GREEN:
                System.out.println(c.show());
                break;
                case YELLOW:
                System.out.println(c.show());
                break;
                default:

        }
    }

}

interface Show {
    Object show();
}

enum Color implements Show {
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    BLACK(0, 0, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0);
    private int r;
    private int g;
    private int b;

    Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }


    @Override
    public String show() {
        return "颜色"+"\t"  + toString() + "三色为" +
                "\t" + r + "\t" + g + "\t" + b;
    }

}