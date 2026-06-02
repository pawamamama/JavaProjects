public class TernaryOperatorExercise {//三元运算符作业

	public static void main(String[] args){
		//求出三个数的最大值
		int n1 = 1;
		int n2 = 2;
		int n3 = 3;
		int max1 = n1 > n2 ? n1 : n2;
		int max2 = max1 > n3 ? max1 : n3;
		System.out.println( "最大数="+ max2 );
		//一条语句实现
		int max3 = (n1 > n2 ? n1 : n2)> n3 ?(n1 > n2 ? n1 : n2): n3;
		System.out.println( "\nmax3最大数="+ max3 );
	}
}