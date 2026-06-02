public class Homework010  {

    public static void main(String[] args) {
    	Employee person = new Employee("wangweixin","男",18,"世界第一科技公司首席执行官",1010101010101010101010101001010101010101010.9);

    	}

}
class Employee {
	String name;
	String gender;
	int age ;
	String levle;
	double money;
	public Employee(String levle, double money) {
		this.levle = levle;
		this.money =money; 
	}
	public Employee(String name,String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public Employee(String name,String gender, int age,String levle, double money) {
		//构造器复用
		this (name,gender,age);
		this.levle = levle;
		this.money =money; 
	}
}