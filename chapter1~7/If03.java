import java.util.Scanner;
public	class If03{
public static void main(String[] args){
	Scanner myScanner = new Scanner(System.in);
		System.out.println("请输入信用分");
	int score = myScanner.nextInt();
	//判断信用分输入是否在1~100范围内
	if (score >= 1 && score <= 100) {
		if (score == 100) {
			System.out.println("您的信用分极好");
		} else if ( score <= 99 && score >  80) {
			System.out.println("您的信用分优秀");
		} else if ( score <= 80 && score >= 60) {
			System.out.println("您的信用分一般");
		} else {
			System.out.println("您的信用分不及格");
	    }
    }else {
    	System.out.println("输入的信用分不在在1~100范围内");
    }
	
}
}