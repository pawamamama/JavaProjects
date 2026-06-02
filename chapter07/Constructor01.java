public class Constructor01 {//构造器快速入门 /构造器细节1 构造器重载

    public static void main(String[] args) {
    	//当我们new一个新个对象时直接通过构造器指定名字和年龄
    		Person p = new Person("wangweixin",18);
			System.out.println(" p1的信息如下");
			System.out.println(" p1对象 name = " + p.name );
			System.out.println(" p1对象 age = " + p.age );
		//构造器重载
    		Person p2 = new Person("刘轩宇");

			System.out.println(" p2的信息如下");

			System.out.println(" p2对象 name = " + p2.name );
  
		//构造器细节2
		Dog gogo = new Dog("腌黄瓜先生");	
		//还想使用 这种的无参数构造器就要显式定义一下就是用无参数的方法写一个 构造器
		Dog gogo = new Dog();


	}		

		   
}class Dog {//构造器细节2
	//构造器如果程序员没有定义构造器系统会自动生成一个无参数构造器(默认构造器)
	//使用javap 反编译Dog.calss能看到默认构造器
	//默认构造器
	/*Dog() {

	}*/
	//一旦定义了自己的构造器，默认的构造器就覆盖了，就不能再使用默认的无参构造器 
	public Dog(String dName) {
		//
	}
	//除非显式定义一下 即： Dog() {}   如果还想用无参数的方法写 Dog gogo = new Dog();
	Dog() { //无参构造器

	}
}
class Person {
	// Person(){}
	String name;
	int age;
	//构造器/构造方法
	public Person(String pName,int pAge) {
			System.out.println("姓名和年龄构造器被调用   完成对象的属性的初始化 ");
			name = pName;
			age = pAge;
	}
	//构造器重载/构造方法重载
	public Person(String pName) {
			System.out.println("姓名构造器（构造器重载）被调用   完成对象的属性的初始化 ");
			name = pName;
	}
}
