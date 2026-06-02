public class VarScope02 {//变量作用域

    public static void main(String[] args) {
    	 Person p = new Person();
    	 /* 属性生命周期较长
    	 伴随着对象的创建而创建伴随着对象的销毁而销毁
    	 局部变量，生命周期较短
    	 伴随着他的代码块执行而创建伴随着代码块的结束而销毁挤
    	 在1次方法调用过程中 
    	 */
    	 p.say();//运行完say方法时say方法的局部变量会比如name创建 say执行完毕后
    	 //name会销毁，但是（全局变量）属性仍然可以使用 
    	 //因为p对象已经创建但是p对象未销毁
    	 //
		//全局变量/属性可以被本类使用,或者其他类使用,通过对象调用 
    	 T t1 = new T();
    	 t1.test();
    	 t1.test2(p);//还可以传对象引用进去，调用
	}		
}
class T {
	public void test() {
	//全局变量/属性可以被本类使用,或者其他类使用,通过对象调用 
	Person p = new Person();
	System.out.println(p.name);
	}
	public void test2(Person p) {//把别的作用域的对象传给它 调用个对象的 全局变量 属性
	System.out.println(p.name);

	}

}

class Person {
 
		//属性全局变量可以加修饰符  public protected private...
		//局部变量不可以		
public String name = "jack";
			public void say() {
				//细节,属性和局部变量可以重名,访问时遵循就近原则 
					String name = "king";//这里如果注释了就是输出Jack 
					System.out.println("say() name = " + name); 
			} 
			
}