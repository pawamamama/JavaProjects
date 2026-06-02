package com.pawamamama.chapter10Homerork;
/**
 * @author pawamamama
 */
public class HomeWork05 {
    public static void main(String[] args) {
        A wang = new A("wang");
        wang.B("liu");
    }
}
class A {
    private String name;
    public A(String name) {
        this.name = name;
    }
    public void B(String name) {
       class B {
            private   String name;

            public B(String name) {
                this.name = name;
            }

            public void show() {
                System.out.println(name);
                System.out.println(A.this.name);
            }
        }
        B b = new B(name);
        b.show();
    }
}
