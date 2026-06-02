public class ConstructorExercise {//构造器练习

    public static void main(String[] args) {
    	Person p = new Person();//无参构造器
    	// name = null age = 18
		System.out.println(" p对象 name = " + p.name + " age = " + p.age);
    	Person p2 = new Person("wangweixin",100000);
		System.out.println(" p2对象 name = " + p2.name + " age = " + p2.age);


    }
}
class Person {
	// Person(){}
	String name;
	int age;
	//无参构造器
	Person() {
		age = 18;//初始值18
	}
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
