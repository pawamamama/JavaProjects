public class Homework05{

    public static void main(String[] args) {
    		Circle c1 = new Circle(3);
    		c1.circlePerimeterAndArea();
    	}

}
	
class Circle {
	
	 double radius;//半径
	 //构造器
	  public Circle(double radius) {
	  	this.radius = radius;
	  } 
	 public void circlePerimeterAndArea() {//显示周长
	 		System.out.println("半径 = " + this.radius + "周长 = " + (2*Math.PI*this.radius));
	 		System.out.println("半径 = " + this.radius + "面积 = " + (Math.PI*this.radius*this.radius));

	 }
}
