public	class methodDetail{
	public static void main(String[] args){
		AA a = new AA();
		int[] res = a.getSumAndSub(50,40);
		 System.out.println(res[0]);
		 System.out.println(res[1]);
		 //同类跨方法调用
		 a.sayOk();
		 //跨类调用
		 a.m1();
		 

	}
}
class AA {
	//1.一个方法最多可以有一个返回值但是可以返回数组和对象 
	//用数组返回 和和差 
	public int[] getSumAndSub(int n1 , int n2) {
		int[] resArr = new int[2];//创建一个接收数组
			resArr[0] = n1 + n2;
			resArr[1] = n1 - n2;
			return resArr;//返回携带目标值的数组
	}
	//2，返回类型可以为任意类型包含基本类型或引用类型 
	//看 getSumAndSub

	//同一个类中方法可以直接调用
	public void print (){
		System.out.println("aaaa");
	} 
	public void sayOk(){
		print();
	}


    //跨类调用：方法a类调用B类方法需要通过对象名调用 
	public void m1() {
		//先创建一个B对象 
		
		System.out.println("a类的 m1()被调用 ");
		BB b = new BB();
		//调用hi方法
		b.hi();
		System.out.println("a类的 m1()继续执行 ");
	}
}
 
class BB {

	 public void hi() {
		System.out.println("b类中的hi()方法被执行");
	 }
}
