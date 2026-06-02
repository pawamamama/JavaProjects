public class Homework06{

    public static void main(String[] args) {
    		Cale cale = new Cale(4,0);
    		System.out.println("和 = " + cale.add());
    		System.out.println("差 = " + cale.reduce());
    		System.out.println("乘 = " + cale.multiply());
    		System.out.println("除 = " + cale.removed());

    	}

}
class Cale {
	 double num1;
	 double num2;
	 public Cale(double num1,double num2) {
	 	this.num1 = num1;
	 	this.num2 = num2;
	 } 
	 public double add() {
	 	return this.num1 + this.num2;
	 }
	 public double reduce() {
	 	return this.num1 - this.num2;
	 }
	 public double multiply() {
	 	return this.num1 * this.num2;
	 }
	 public Double removed() {
	 	if (num2 == 0) {
	 		System.out.println("不能为零");
	 		return null;
	 	}
	 	return this.num1 / this.num2;
	 }
}
