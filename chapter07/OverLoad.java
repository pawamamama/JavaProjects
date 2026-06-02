public class OverLoad {
    public static void main(String[] args) {
    	//重载函数快速入门 
    	MyCalculator cal = new MyCalculator();
    	System.out.println(cal.calculate(1,10));
		System.out.println(cal.calculate(1,10.5));
		System.out.println(cal.calculate(1.9222,10));
		System.out.println(cal.calculate(1,10,100));
    }
}
class MyCalculator {
	public int calculate(int n1, int n2) {
    System.out.println("调用方法：calculate(int n1, int n2)");
    System.out.println("被调用参数：" + n1 + ", " + n2);
    return n1 + n2;
}

public double calculate(int n1, double n2) {
    System.out.println("调用方法：calculate(int n1, double n2)");
    System.out.println("被调用参数：" + n1 + ", " + n2);
    return n1 + n2;
}

public double calculate(double n1, int n2) {
    System.out.println("调用方法：calculate(double n1, int n2)");
    System.out.println("被调用参数：" + n1 + ", " + n2);
    return n1 + n2;
}

public int calculate(int n1, int n2, int n3) {
    System.out.println("调用方法：calculate(int n1, int n2, int n3)");
    System.out.println("被调用参数：" + n1 + ", " + n2 + ", " + n3);
    return n1 + n2 + n3;
}
}