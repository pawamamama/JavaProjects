public	class methud01{
	public static void main(String[] args){
		//方法使用
		//1.方法写好后如果不去调用 则不会输出 不会生效
		//2.先创建一个对象 ，然后调用方法即可 
	 	person p1 = new person();
	 	p1.speack();//调用方法 
	 	p1.cal01();
	 	p1.cal02(5);//调用Cal零二方法 同时给n= 5
	 	//把p1.getSum(10,20);返回的值赋值给变量returnRes
	 	//方法调用小结 
	 	//1.当程序执行到方法时就会开辟一个独立的空间（栈空间）
	 	//2.当方法执行完毕 或者执行到return语句 语句就会返回,销毁那个独立的栈空间 
	 	//3.返回到调用方法的地方
	 	//4.返回后继续执行方法后面的代码 
	 	//5.执行完main方法（栈）执行完毕 , 整个程序退出 
	 	int returnRes = p1.getSum(10,20);
	 	System.out.println("getSum方法返回的值" + returnRes);




	}
}

class person {
	String name;
	int age;
	//方法(成员方法)
	//1. public 表示方法是公开 
	//2. void : 表示方法没有返回值
	//3. speak  方法名 ，()形参列表 
	//4. {}方法体,可以写我们要执行的 代码/功能
	public void speack() { 
		System.out.println("轩宇最好了~~");
	}
	//添加cal01方法 ，要求计算1~1000的和
	public void cal01(){
		int res = 0;
		for (int i = 1;i <= 1000 ; i++ ) {
			res += i;
		}
		System.out.println("cal01方法计算结果" + res);
	}
	//添加一个cal02方法要求接收一个n，计算1~n的和
	//(int n)形参列表，表示当前有一个形参n，可以接收用户输入 
		public void cal02(int n){//形参列表，表示当前可以传入一个形参 
		int res = 0;
		for (int i = 1;i <= n ; i++ ) {
			res += i;
		}
		System.out.println("cal02方法计算结果" + res);
	}
	//添加一个getSum方法计算两个数的和
	// int 方法执行后需要返回一个int 值
	public int getSum(int num1, int num2){
		int res = num1 +num2;
		return res;//返回计算后的和
	}
} 