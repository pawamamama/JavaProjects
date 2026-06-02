 // 主类（程序入口）

public class ThisExercise{

    public static void main(String[] args) {
       T t1 = new T();
       t1.f2();
       t1.f3();
    }

}
class T {
	String name = "JACK";
	int age = 100;
	//访问构造器语法this(参数列表); 
	//注意只能在构造器中使用(即只能在构造器中访问另外一个构造器)
	//访问构造器语法 this(参数列表); 必须置于第一条语句
	public T() {
			//这里去访问 T(String name,int age) 构造器
			this("jack",1000);
			System.out.println("T() 构造器");
	} 
	public T(String name,int age) {
			this.name = name;
			this.age = age;
			System.out.println("T(String name,int age) 构造器");

	} 
	//访问成员方法的语法: this方法名(参数列表) 
	public void f1() {
		System.out.println("f1()方法 。。");
	}
	public void f2() {
		System.out.println("f2()方法 。。");
		//调用 本类的 f1
		//第一种
		f1();
		//第二种
		this.f1();
	}
	//this 关键字可以用来访问本类的属性
	public void f3() {
		String name = "mama";
		int age = 100; 
		System.out.println("f3()方法名字 = " + name +"\tf3()年龄 = " + age);//容易和局部变量混淆 （作用域就近原则）
		//这样写可以避免混淆
		System.out.println("当前对象名字 = " + this.name +"\t当前对象年龄 = " + this.age);
	} 
}
