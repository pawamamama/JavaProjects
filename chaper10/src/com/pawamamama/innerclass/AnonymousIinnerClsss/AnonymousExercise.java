package com.pawamamama.innerclass.AnonymousIinnerClsss;

public class AnonymousExercise {
    public static void main(String[] args) {
        //匿名内部类当作实参直接传递
        f1(new AA() {//这里创建好后直接返回对象引用
            @Override
            public void show() {
                System.out.println("当作实参直接传递");
            }
        });
        //简洁高效，使用完了之后类和对象直接销毁不用了
    }
    //静态方法
    public static void f1(AA aa) {//可接收
        aa.show();//这里对象
        // 匿名对象AnonymousExercise&1
        //实现了接口的show()方法
        //所以能直接aa.show();
    }
}

interface AA {
    void show();
}