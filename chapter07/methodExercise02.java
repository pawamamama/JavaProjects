public	class methodExercise02 {

	public static void main(String[] args){
	//编写一个方法copyPerson可以复制一个person对象,
	//返回复制的对象,克隆对象
	//注意要求得到的新对象和原来的对象是两个独立的对象只是他们属性相同 
	Person p = new Person();
	p.name = "轩宇";
	p.age = 18;
	//创建拷贝方法对象 
	MyTools me = new MyTools();
	//把返回的 对象的引用 
	Person p2 = me.copyPerson(p);
	//到此p和P2Person对象 是两个独立的并且属性相同 
	System.out.println("到此p和P2Person对象 是两个独立的并且属性相同 ");
	System.out.println("p对象" + p.name +"\t" + p.age);
	System.out.println("p2对象" + p2.name +"\t" + p2.age);
	//hashcode
	System.out.println("p对象的hashcode（简单理解就是地址）" + p );
	System.out.println("p2对象的hashcode（简单理解就是地址）" + p2 );

	//判断
	System.out.println(p == p2);



	}
}
class Person {
	String name;
	int age;
}
class MyTools {

	public Person copyPerson (Person p) {
	//创建一个新对象 
	Person p2 = new Person();
	//进行拷贝操作 
	 p2.name = p.name;
	 p2.age = p.age;
	 return p2; // 返回新创建对象的引用（即指向该对象的内存地址）

	}
}