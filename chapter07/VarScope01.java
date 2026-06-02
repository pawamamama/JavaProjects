public class VarScope01 {//变量作用域

    public static void main(String[] args) {

		}

}
class Cat {
		//全局变量:也就是属性 ,作用域为整个类体 Cat类 cry eat 等方法使用属性
	    //属性在定义时可以直接赋值 
		int age = 10; 
		//属性可以不赋值因为它有默认值 局部变量必须赋值后才能使用因为没有默认值 
		double weight;//默认值是0.0
		{
			int num = 100;//这个是一个局部变量 作用域为定义它的代码块中
		}
		//简单理解出了自己的代码块就不能使用了 
	public void cry() {
		//1.局部变量一般是指在成员方法中定义的变量 
		//2.n和 name 就是局部变量
		//3，n name 的作用域在 cry 方法中
		int n = 10;
		String name = 'tom';
		//在cry方法中使用属性age
		Sytem.out.println(age);
	}
	public void eat() {
			Sytem.out.println(age);
	}
}
