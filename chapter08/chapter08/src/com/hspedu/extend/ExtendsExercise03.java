package com.hspedu.extend;

public class ExtendsExercise03 {
    static void main(String[] args) {
        PC pc = new PC("r9-7945hx", "ddr5 8+8双通道16gb", "1tb固态", "联想9000p2023");
        String pc1 = pc.getInfo();
        System.out.println(pc1);
        NotePad notePad = new NotePad("晓龙8+gen1", "8g", "256", "银白");
        System.out.println(notePad.getInfo());

    }
}

class Computer {
    //私有化属性避免 this. 直接访问 想用就老老实实用公共构造器
    private String cpu, mem, ssd;

    public Computer(String cpu, String mem, String ssd) {
        this.cpu = cpu;
        this.mem = mem;
        this.ssd = ssd;
    }
    //直接调用
    public String getCpu() {
        return cpu;
    }

    public String getMem() {
        return mem;
    }

    public String getSsd() {
        return ssd;
    }

    public String getDetails() {//获取详情

        return "CPU:" + cpu + "  内存:" + mem + "  硬盘:" + ssd;
    }
}

class PC extends Computer {
    private String brand;

    public PC(String cpu, String mem, String ssd, String brand) {
        super(cpu, mem, ssd);
        this.brand = brand;
    }

    public String getInfo() {//两个子类统一get方法名以后好多态
        System.out.println("电脑信息");
        //复用getDetails();父类逻辑
        return getDetails() + "品牌:" + brand;
    }
}

class NotePad extends Computer {
   private String color;

    public NotePad(String cpu, String mem, String ssd, String color) {
        super(cpu, mem, ssd);
        this.color = color;
    }

    public String getInfo() {//两个子类统一get方法名以后好多态
        System.out.println("平板信息");
        return getDetails() + "颜色:" + color;
    }
}
