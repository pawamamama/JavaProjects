public class OverLoadExercise {

    public static void main(String[] args) {
    	Methods mts = new Methods();
    	mts.max(10);
    	mts.max(1010,10);
    	mts.max('a');


	}
}
class Methods {
		public void max(int n1) {
			System.out.println(n1 * n1);

	}
		public void max(int n1,int n2) {
			System.out.println(n1 * n2);
	}
		public void max(char c1) {
			System.out.println(c1);
	}
}