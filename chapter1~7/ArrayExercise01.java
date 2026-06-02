import java.util.Scanner;//表示把java.util包下的类导入到文件
public	class ArrayExercise01{
	public static void main(String[] args){
		//打印26个英文大写字母用chars[]存放后打印
		//Scanner类 表示  简单文本扫描器
		//1.引入 Scanner 类所在的包
		//2.创建 Scanner 对象,new 创建一个对象
		Scanner myScanner = new Scanner(System.in);//in代表从键盘输入
		
		//第二种 动态分配方式
		char[] chars; //先声明数组这时数组是null
		chars = new char[26];//分配内存空间，这时才可以存放
		//scores.length表示数组的大小/length长度
		for (int i = 0;i < chars.length ;i++) {
			//复合赋值运算需要进行强制转换
			//chars[i] = (char)('A' + i);//'A' + i 是int 需要进行强制转换
		}
		//输出，遍历数组
		for (int i = 0;i < chars.length ;i++) {
			System.out.println("第"+(i+1)+"个元素数值为"+chars[i]);
		}
	  }	
}