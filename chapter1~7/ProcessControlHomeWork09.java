public	class ProcessControlHomeWork09{//流程控制作业07
public static void main(String[] args){
	//输出累加累加100的和
	int sum = 0;
	int mum = 0;
	for (int i = 1;i <=100;i++) {
		    mum += i;
		    sum += mum; 
	}
		System.out.println( "第一种使用两个变量一个循环"+ sum);
	int sum = 0
    for (int i = 1;i<= 100 ; i++) {
    	for (int j =1;j <= i ; ) {
    		sum += j; 
    	}
    }
    	System.out.println( "第二种使用一个变量两个循环嵌套"+ sum);
}}