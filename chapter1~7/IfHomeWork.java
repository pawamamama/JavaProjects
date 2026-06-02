import java.util.Scanner;//表示把java.util包下的类导入到文件
public	class IfHomeWork{
public static void main(String[] args){
	System.out.println("第一题");
	double a = 11.4,b = 19.8;
	if ( a > 10.0 && b<20.0) {
		System.out.println(a+b);
	}
	System.out.println("第二题");
	int a1 = 10 ,b1 = 5 ;
	int c1 = a1 + b1 ;
	if (c1 / 3 == 0 && c1 / 5 == 0 ) {
		System.out.println(c1 + "可以被3和5整除");
	}
	System.out.println("第三题平闰年");
	//构造对象
	Scanner myScnner = new Scanner(System.in);//in代表从键盘输入
	System.out.println("请输入年份");
	int year = myScnner.nextInt();//接收年份
	if ((year / 4 == 0 && year /100 != 0) || year / 400 ==0 ) {
		System.out.println(year + "是闰年");
	}
	else{
		System.out.println(year + "是平年");
	}
	
}
}