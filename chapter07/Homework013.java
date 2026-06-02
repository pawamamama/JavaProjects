public class Homework013{

    public static void main(String[] args) {
    		Circle c = new Circle();
    		PassObject pass = new PassObject();
    		pass.printAreas(c,1000);
    	
    	}

}
	
class Circle {
	
	 double radius;//半径
	 //无参数构造器
	 Circle () {

	 }
	 //构造器
    public Circle(double radius) {
    	this.radius = radius;
    } 
	public double findArea() {
		return radius * radius *Math.PI; 
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
class PassObject {
	public void printAreas(Circle c,int times ) {
		System.out.println("Readius\tArea");
		for (int i = 1 ;i <= times ;i ++ ) {
			//c.radius = i;可以封装
			c.setRadius(i);
			System.out.println((double)i + "\t" + c.findArea());
		}
	}
}  
