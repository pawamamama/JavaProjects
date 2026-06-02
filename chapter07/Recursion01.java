public class Recursion01 {

	public static void main(String[] args){
		Tools t = new Tools();
		t.test(4); // 从 n=4 开始递归调用
		// 递归特点：先进后出 后进先出（栈结构）
		//阶乘
		int res = t.factorial(4);//1
		System.out.println("res = " + res); 
	}
}

class Tools {
	public void test(int n) {
		// 递归出口控制（不是严格终止，而是停止继续深入）
		//如果写在这里的话 会变成 4 ，3 ，2 先执行输出
		//System.out.println("n = " + n);
		if (n > 2) {
			test(n - 1); // 向下递归，压栈
		}
		
		// 回溯阶段执行（出栈时执行）
		System.out.println("n = " + n);//是 2，3，4
	}
	public int factorial (int n) {//阶乘
		if (n == 1) {
			return 1;
		} else {
			return factorial(n -1) * n;
		}
		//回溯阶段执行效果 执行效果 1*2*3*4 = 24
	} 
}