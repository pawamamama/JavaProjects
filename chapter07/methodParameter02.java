public	class methodParameter02 {

	public static void main(String[] args){
  //引用数据类型传参机制 
	//数组
	B b = new B();
	/*int[] arr = {10,20,30};
	b.test100(arr); 
	System.out.println("main的arr数组");	
	for (int i = 0;i < arr.length;i++ ) {
		
			System.out.print(arr[i] + " ");
	}
 		System.out.println();	*/
 	//Java中所有的数值都是值传递 
 	//只是传递的方式不一样 这里传递的是 引用传递 而数组真实情况是在堆里面
 	//对象传递
 	Person p = new Person();
 	p.age = 1010; 
 	p.name = "mama"; 
 	b.test200(p);
	System.out.println("main的 P.age = " + p.age);	
	System.out.println("main的 P.name = " + p.name);	
 

	}
}
class Person {
	String name;
	int age;
}
class B {
	//
	public void test200(Person p) {
		p.name = "轩宇";
		p.age = 10000;
		p = null;//test200 这里置空不影响mian的p仍然是指向p代表的对象空间
	}
	//写一个方法test100
	//可以接受一个数组    在方法中修改该数组看看 原来的数组是否发生变化 
	public void test100 (int[] arr) {
		arr[0] = 200;//修改元素 
		//对传入的arr数组进行遍历输出
	System.out.println("test方法的arr数组");	
	for (int i = 0;i < arr.length;i++ ) {
		
			System.out.print(arr[i] + " ");
	}
 		System.out.println();	

	}
}