import java.util.Scanner;//表示把java.util包下的类导入到文件
public	class Array02{//流程控制作业07
	public static void main(String[] args){
		//输入五个成绩，输出
		//Scanner类 表示  简单文本扫描器
		//1.引入 Scanner 类所在的包
		//2.创建 Scanner 对象,new 创建一个对象
		Scanner myScanner = new Scanner(System.in);//in代表从键盘输入
		//第一种 动态分配方式
		//double scores[] = new double[5];//直接定义时就分配
		//第二种 动态分配方式
		double scores[]; //先声明数组这是数组是null
		scores = new double[5];//分配内存空间，这时才可以存放
		//scores.length表示数组的大小/length长度
		for (int i = 0;i < scores.length ;i++) {
			System.out.println("输入第"+(i+1)+"个元素");
			scores[i] = myScanner.nextDouble();
		}
		//输出，遍历数组
		for (int i = 0;i < scores.length ;i++) {
			System.out.println("第"+(i+1)+"个元素数值为"+scores[i]);
		}
	 }	
}