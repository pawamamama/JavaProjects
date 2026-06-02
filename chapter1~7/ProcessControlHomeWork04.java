import java.util.Scanner;//表示把java.util包下的类导入到文件
public	class ProcessControlHomeWork04{//流程控制作业04
public static void main(String[] args){
		//水仙花数
	//int n = 153;
	//得到百位，十位，个位的数字
	//百位 n100 = n / 100;
	//十位 n10 = n % 100 / 10;
	//个位 n1 = n % 10
	Scanner myScnner = new Scanner(System.in);//in代表从键盘输
	int n = myScnner.nextInt();
	if (n>100&&n < 1000) {//输入检查
		int n100 = n / 100;
		int n10 = n % 100 / 10;
		int n1 = n % 10;
		if (n1 * n1 * n1 + n10 * n10 * n10 + n100 * n100 * n100 == n) {
				System.out.println(n+"是水仙花数");
		} else {
				System.out.println(n+"不是水仙花数");
		}
	}else {
		System.out.println("不是三位数");
	}
}}