import java.util.Scanner;
public	class NestedIf{
public static void main(String[] args){
	Scanner myScanner = new Scanner(System.in);
	System.out.println("请输入歌手的成绩");
	double score =myScanner.nextDouble();
	if (score > 8.0) {
		System.out.println("请输入歌手的性别");
		char gender =myScanner.next().charAt(0);//获取第一个字符，详情在笔记String转char里面
		//String gender = myScanner.next(); // 改为String类型
		if (gender == '男') {
			System.out.println("进入" + gender +"子组"+ "成绩" + score);
		}else if (gender == '女') {
			System.out.println("进入" + gender +"子组"+ "成绩" + score);
		}else {
			System.out.println("性别输入错误");
		}

			
	}else {
		System.out.println("淘汰");
	}




}
}
