public class RecursionExercise01 {

	public static void main(String[] args){
		int n = -1;
		T t1 = new T();
		int res = t1.Fibonacci(n);
		if (res != -1) {
			System.out.println("当n = "+ n +"对应的斐波纳契数 = " + res);
		} else {
			System.out.println("数据有误 ");
		}
	}
}

class T {
	public int Fibonacci (int n) {
		if (n >= 1) {
		
		   if (n == 1 || n == 2) {
		   		return 1;
		   } else {
		   		return Fibonacci (n -1) + Fibonacci(n-2  )
		   }	
		} else {
			System.out.println("要求输入的N大于等于一");
			return -1;
		}
	}
}