public class VariableParametersDetail{//细节
	//可变参数 = 自动帮你创建一个数组来接收参数,语法糖
	//参数的实参可以是数组 
    public static void main(String[] args) {
    	HspMethod hsp = new HspMethod();
    	//可变参数的实参可以是数组 
    	int[] arr = {1,2,3,4} ;
        hsp.f1(arr);
    	System.out.println();
	}

}
class HspMethod {
	public void f1 (int ... nums) {
		System.out.println("可变参数接收的个数是" + nums.length);
		
	}  
	//细节 ，可变参数可以和普通类型的参数一起放在形参列表但必须保证可变参数在最后 
	//如果放后面的话编译器不知道什么时候 接收 那个单独的形参列表 
	//可变参数是零到无穷 ，而且还有自动类型转换形参列表必须写在前面 
	public void f2 (String str, int ... nums) {

	}
		//一个形参列表中只能出现一个可变参数
	/*public void f2 (String... str, int ... nums) {错误

	}*/
}