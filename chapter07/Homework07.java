public class Homework07{

    public static void main(String[] args) {
    		Dog g1 = new Dog("大黄","黄色",3);
    		Dog g2 = new Dog("大白","白色",3);
    		g1.shows();
    		g2.shows();
    	}

}
class Dog {
	String name;
	String color;
	int age;
	//构造器
	public Dog(String name,String color,int age) {
		this.name =name;
		this.color = color;
		this.age = age;
	}
	//打印
	public void shows() {
		System.out.println("名字 = " + this.name);
		System.out.println("颜色 = " + this.color);
		System.out.println("年龄 = " + this.age);

	}
}