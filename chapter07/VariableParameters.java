public class VariableParameters{
	//可变参数 = 自动帮你创建一个数组来接收参数,语法糖
    public static void main(String[] args) {
    	HspMethod hsp = new HspMethod();
    	 int sum = hsp.sum(1,2,3,4,5,6,7);
    	System.out.println(sum);
	}

}
class HspMethod {
	//可变参数优化，写一个 计算一个数的和两个数的和三个数的和然后 如果这样写的话会造成代码冗余 
	//然后我们现在想用一个方法就可以计算可变的参数
	//1. int... 表示接收的可变参数类型是int的 ，可以接受多个int的值 零到多个  （0~多）
	//2.使用可变参数参数时可以当成数组去使用 nums 可以当作数组 
	//3.既然是数组那我们就遍历求和 
	//4.感觉像是把 传进来的实参封装进了int数组 方便我们使用 但是这样弄的话它 损耗性能吗需要便利 
	public int sum(int ... nums) {
		System.out.println("可变参数接收的个数是" + nums.length);
		int res = 0;
		for (int i = 0;i < nums.length ;i++ ) {
			res += nums[i];
		}
		return res;
	}  
}