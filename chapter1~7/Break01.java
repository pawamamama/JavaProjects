import java.util.Scanner;
public	class Break01{
public static void main(String[] args){
	Scanner myScanner =  new Scanner(System.in);
	String name = "";
	String passwd = "";
	int chance = 3;//登录机会
	for (int i = 1;i <= 3;i++){
		System.out.println("请输入名字");
		name = myScanner.next();
		System.out.println("请输入密码");
		passwd = myScanner.next();
		//比较
		if("丁真".equals(name) && "666".equals(passwd)){
				System.out.println("登录成功");
				break;
		}
		//登录机会减少
		chance--;
		System.out.println("登录机会还剩"+chance+"次");

	}
}}