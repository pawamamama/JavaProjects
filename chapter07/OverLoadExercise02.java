public class OverLoadExercise {

    public static void main(String[] args) {
    	Methods me = new Methods(); 
    	System.out.println(me.max(20, 30));
        System.out.println(me.max(500.1111, 101010.333));
        System.out.println(me.max(11.7, 10.5, 66.6));
	}
}
class Methods {
	public int max(int n1,int n2) {
		return n1>n2 ? n1 : n2;
	}
	public double max(double n1,double n2) {
		return n1>n2 ? n1 : n2;
	}
	public double max(double n1,double n2,double n3) {
		return max (max(n1,n2),n3);//直接嵌套 
		//用上一个对比方法嵌套一下
		//对比n1,n2 数得到最大值然后 再套一个对比方法继续和n3对比 可以无限套娃
		//return (n1>n2 ? n1 : n2) > n3 ? (n1>n2 ? n1 : n2) : n3 ;
	}
}
