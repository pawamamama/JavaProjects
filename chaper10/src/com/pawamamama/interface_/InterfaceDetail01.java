package com.pawamamama.interface_;

public class InterfaceDetail01 {
    public static void main(String[] args) {
        //1.接口不能实例化,接口本身是希望类去实例化他
        //new IA();
    }
}


  interface IA {
    //2.接口中所有方法是public 方法，接口中抽象方法，可以不用用abstract修饰
    public abstract void aaa();

    void bbb();
    //所以可以省略 public  abstract
    //3.一个普通类实现接口，就必须将该接口的所有方法都实现
    //4，抽象类实现接口，可以不用实现接口的方法
      //java 9之后为了内部复用可以写 私有方法
      private void hello() {
        System.out.println("hello");
      }
      default void ccc() {
          System.out.println("ccc");
      }
}

//alt + enter 快速实现接口
class IB implements IA {
    @Override
    public void aaa() {
        System.out.println("aaa");
    }

    @Override
    public void bbb() {
        System.out.println("bbb");
    }
}

//4，抽象类实现接口，可以不用实现接口的方法
abstract class  ICC implements IA {
    abstract public void ccc();
}
    class  C extends ICC {

        @Override
        public void aaa() {

        }

        @Override
        public void bbb() {

        }

        @Override
        public void ccc() {

        }
    }
