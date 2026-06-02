public class StringToBasic{


	public static void main(String[] args){
		//基本数据类型-> Sting 类型''
		long l1 = 1111111;
		int n1 = 100;
		float f1 = 1.1f;
		double d1 = 4.5;
		boolean b1 = true;
 		String s0 = l1 + "";
		String s1 = n1 + "";  
		String s2 = f1 + "";  
		String s3 = d1 + "";  
		String s4 = b1 + "";  
		System.out.println(s0+" "+s1+" "+s2+" "+s3+" "+s4);//""不加也行，是为了分隔

		//从String转换到对应的基本数据类型   parse 英文为解析
	    int num1 = Integer.parseInt(s1);
	    float num2 = Float. parseFloat(s2);
	    double num3 = Double.parseDouble(s3);
	    Long num4 = Long.parseLong(s0);
	    System.out.println(num1); 
	    System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		//String->char ,不能转换但是可以得到字符串里的一位字符   
		//可以使用 num0.charAt(0)得到第一个字符
		String num0 = "901010";
		System.out.println(num0.charAt(0));


	}
}