package com.hspedu.poly_;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //主人给小狗喂食
//    public void feed(Dog dog,Bone bone) {
//        System.out.println("主人"+name+"給"+dog.getName()+"喂"+bone.getName());
//    }
//    //小猫
//    public void feed(Cat cat,Fish fish) {
//        System.out.println("主人"+name+"給"+cat.getName()+"喂"+fish.getName());
//    }
//    //如果动物很多，食物很多
    // feed方法很多，不利于管理
    //多态来处理喂食
    public void feed(Animal animal,Food food) {
        System.out.println("主人"+name+"給"+animal.getName()+"喂"+food.getName());
    }
}
