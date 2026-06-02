public class ThisDetail02{//细节

    public static void main(String[] args) {
    	Person p1 = new Person("王"，10000);
    	Person p2 = new Person("dada"，100);
    	if (p1.compareTo(p2)) {
			System.out.println("一样");
    	} {
			System.out.println("不一样");
    	}
    }

}
class Person {
	String name ;
	int age 
	public Person(String name , int age) {
		this.name = name;
		this.age = age;
	}
	public boolean compareTo(Person p) {
		return this.name.equals(p.name)&&this.age ==p.age;
	}
}