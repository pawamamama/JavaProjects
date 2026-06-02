package com.pawamamama.chapter10Homerork;

/**
 * @author pawamamama
 */
public class HomeWork03 {
    static void main(String[] args) {
        Animal cat = new Cat();
        Animal gog = new Gog();
        cat.shout();
        gog.shout();
    }
}
abstract  class Animal {
    public abstract void shout();
}
class Cat extends Animal {
    @Override
    public void shout() {
        System.out.println("猫会喵喵叫");
    }
}
class Gog extends Animal {
    @Override
    public void shout() {
        System.out.println("狗会汪汪叫");
    }
}