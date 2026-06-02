import java.util.Scanner;//表示把java.util包下的类导入到文件
public	class Input{
public static void main(String[] args){
	//演示接受用户的输入
	//步骤
	//Scanner类 表示  简单文本扫描器
	//1.引入 Scanner 类所在的包
	//2.创建 Scanner 对象,new 创建一个对象
	Scanner myScnner = new Scanner(System.in);//in代表从键盘输入
	//3.接收用户输入,使用相关方法
	System.out.println(0xa45+" "+02456);
	System.out.println("请输入名字");
	//当程序执行到 next 方法时 ，会等待用户输入
	String name = myScnner.next();//接收用户输入字符串,next只接收空格前的，所以想连空格一起接收可用nextLine
	System.out.println("请输入年龄");
	int age = myScnner.nextInt();//接收用户输入int
	System.out.println("请输入薪水");
	double sal = myScnner.nextDouble();//接收用户输入double
	//输出信息
	System.out.println("人的信息如下：");
	System.out.println("名字=" + name + " 年龄=" + age + " 薪水=" + sal);



}
}