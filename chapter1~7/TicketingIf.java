import java.util.Scanner;
public	class TicketingIf{
public static void main(String[] args){
	int highSeasonTicket = 60;
	int offSeasonTicket = 40; 
	Scanner myScanner = new Scanner(System.in);
	System.out.println("输入月份");
	int month = myScanner.nextInt();
	System.out.println("输入年龄");
	int age = myScanner.nextInt();
	if (month >= 4 && month <= 10){
		if (age >= 18 && age <= 60) {
			System.out.println("成人票价" + highSeasonTicket);
		} else if (age < 18 && age > 0 ) {
			System.out.println("儿童票价" + highSeasonTicket/2);
		} else if (age > 60){
			System.out.println("老人票价" + highSeasonTicket/3);
		}else {
			System.out.println("非法年龄");
		}
		
	} else if ((month < 4 && month > 0) || (month > 10 && month < 13)){
			if (age >= 18 && age <= 60) {
			System.out.println("成人票价" + offSeasonTicket);
		} else if (age < 18 && age > 0 ){ 
			System.out.println("其他票价" + offSeasonTicket/2);
		} else if (age > 60){
			System.out.println("其他票价" + offSeasonTicket/2);
		}else {
			System.out.println("非法年龄");
		}
	} else {
		System.out.println("非法日期");
	}
	 


}
}