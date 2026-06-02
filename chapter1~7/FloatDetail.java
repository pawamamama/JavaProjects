public class FloatDetail{
	//编写一个main方法
	public static void main(String[] args){
	//java默认为double类型，要使用float类型需要加后缀f或者F    
    float num =1.1F;

     double num1 =2.7;
     //num2运算后会得到近似2.1的小数而不是2.7
     double num2 = 8.1/3;	
     //对小数的运算结果进行相等判断时，应该以两个数差值的绝对值来判断
     if(num1==num2){
     	System.out.println("错误写法");
     }
     if (Math.abs(num1 - num2) < 0.00001 ) {
     	System.out.println("差值非常小，到我规定的精度，认为相等");	
   

     }
   
	}
}