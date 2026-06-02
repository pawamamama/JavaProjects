package com.pawamamama.codeblock_;

public class CodeBlock01 {
}

class Movie {
    private String name;
    private double price;
    private String director; // 导演

    // 实例初始化块，每次创建对象都会执行   代码块调用是优先于构造器的
    {
        System.out.println("电影屏幕打开"); // 屏幕打开
        System.out.println("广告播放");     // 广告
        System.out.println("电影开始");     // 正片开始
    }

    // 构造器重载，只初始化属性
    public Movie(String name) {
        this.name = name;
    }

    public Movie(double price, String director) {
        this.price = price;
        this.director = director;
    }

    public Movie(String name, double price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
    }

    public static void main(String[] args) {
        // 创建对象就会执行实例初始化块
        Movie m1 = new Movie("复仇者联盟");
        Movie m2 = new Movie(50, "乔斯·韦登");
        Movie m3 = new Movie("复仇者联盟", 50, "乔斯·韦登");
    }
}