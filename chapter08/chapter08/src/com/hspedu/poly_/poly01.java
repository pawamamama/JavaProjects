package com.hspedu.poly_;

public class poly01 {
    static void main(String[] args) {
/*        Master wwx = new Master("wangweixin");
        Dog 吴俊希 = new Dog("吴俊希", 17);
        Bone bone = new Bone("爱吃的鸡胸肉");
        wwx.feed(吴俊希, bone);
        Cat 刘达 = new Cat("刘达", 17);
        Fish fish = new Fish("紫罗兰便后你");
        wwx.feed(刘达, fish);
        */

        Master wwx = new Master("wwx");
        Animal animal = new Dog("吴俊希",17);
        Food food = new Bone("爱吃的鸡胸肉 ");
        wwx.feed(animal,food);



        animal = new Cat("刘达",17);
        food = new Fish("清蒸鱼头 ");
        wwx.feed(animal,food);
        animal = new Pig("wujuxi",18);
        food = new Rice("超级米饭");
        wwx.feed(animal,food);
    }
}
