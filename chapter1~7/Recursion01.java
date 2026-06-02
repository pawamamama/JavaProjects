public	class Recursion01 {

	public static void main(String[] args){
		Tools t = new Tools();
		t.test(4);//输出什么?


	}
}

class Tools {
	public void test(int n) {
		if (n > 2) {
			tese(n - 1);
		}
		System.out.println("n = " + n);
	}
}

