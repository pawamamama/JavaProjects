import java.util.Scanner;//表示把java.util包下的类导入到文件
public	class If01{
public static void main(String[] args){
	Scanner myScanner = new Scanner(System.in);//in代表从键盘输入
	System.out.println("请输入年龄");
	int age = myScanner.nextInt();
	if (age>18) {
		System.out.println("你年龄大于18，要对自己行为负责，送进监狱");
	}
	System.out.println("程序继续");

}
}