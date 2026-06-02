public	class Object01{
	public static void main(String[] args){
		//使用oop面向对象
		//实例化一只猫对象
		//1.先声明在创建
		//cat1是对象名（一个对象的引用）
		//new Cat(); 创建的对象空间（数据才是真正的对象）
		Cat cat1;//栈里是null
		cat1 = new Cat();//此时才分配空间 ，此时才把创建空间的地址填回到栈区，cat1 指向 了new Cat()创建的空间
		cat1.name = "小白";
		cat1.age = 3;
		cat1.color = "白色";
		//第二只猫对象
		//2.直接创建，
		Cat cat2 = new Cat();
		cat2.name = "花花";
		cat2.age = 10;
		cat2.color = "粉色"; 
		//类与对象的分配机制 （重要）
		//是引用（值）传递，所以指向了第一只猫的对象空间
		Cat cat3 = cat1;//把c1赋值给了c3,或者说让 C3指向 C1 
		//访问
		System.out.println("第一支猫的信息" + cat1.name+cat1.age+cat1.color);
		System.out.println("第一支猫的信息（分配机制）" + cat3.name+cat3.age+cat3.color);
		System.out.println("第二支猫的信息" + cat2.name+cat2.age+cat2.color);
		//对象属性默认值,遵守数组规则

	}
}



//定义一个猫类
class Cat {
	//属性
	String name;
	int age;
	String color;


	//添加行为

}