//public公有类，公有类名必须匹配文件名
public class hello{
	
	public static void main(String[] args){
		System.out.println("hello word----");
	}
}
//编译后每一个类都对应一个,class文件
class dog {

    //可以将main方法写在非public类，编译运行你指定的类，这样入口方法就是在非public的main方法
	public static void main(String[] args){
		System.out.println("hello 小狗狗----");
	}
}