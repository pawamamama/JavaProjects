public class Homework03{

    public static void main(String[] args) {
    	Book b1 = new Book("人类简史",1010.11);
    	b1.showsBook();
    	b1.updatePrice();
		System.out.println("修改后" );
    	b1.showsBook();
    	}

}
class Book {
	String name;
	double price; 
	public  Book(String name,double price) {
		this.name = name;
		this.price = price;
	}
	public void updatePrice(){
		if (this.price > 150) {
			this.price = 150;
		}else if (this.price >100) {
			this.price = 100;
		}
	}
	//显示书籍情况
	public void showsBook() {
		System.out.println("书籍名称 " + this.name +"\t价格 " +this.price );
	}
} 