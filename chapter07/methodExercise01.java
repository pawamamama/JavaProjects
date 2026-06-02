public	class methodExercise01{

	public static void main(String[] args){
		//1.编写一个类
		//有一个方法:判断一个数是奇数odd还是偶数返回布尔值 
		 AA a = new AA();
		 if (a.isOdd(1)) {//这里其实是直接返回一个布尔值所以可以用if 
		 	System.out.println("是奇数");
		 }else {
		 	System.out.println("是偶数");
		 }
		 //2.打印char
		 a.printChar(30,30, '#');
	}
}
class AA {
	//1.编写判断奇偶
	public boolean isOdd (int num ) {
		/*if (num % 2 != 0) {
			return true;
		}else {
			return false;
		}*/
		//直接返回三目运算符得到的值，简便 
		//return num % 2 != 0 ? true ：false;
		//最简单 != 表达式运算后就直接是bool类型
		return num % 2 != 0 ;
	}
	//2.根据行列字符打印 对应行数和列数的字符 
	// 比如 行四列四 字符是# 则打印以相应的效果 
	/*效果
			####
			####
			####
			####

	*/
	//方法的返回类型 void
	//方法的名字 printChar
	//方法的形参 (int row ,int col,char c )
	//方法体 嵌套循环
	public void printChar(int row ,int col,char c ) {
		for (int i = 1;i <= row ;i ++ ) {
			for (int j  = 1;j <= col ;j ++ ) {
				System.out.print(" " + c);
			}
			System.out.println();
		}
	}

}