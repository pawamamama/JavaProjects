public	class ProcessControlHomeWork01{//流程控制作业01
public static void main(String[] args){
	//路口问题
	int count = 0;//通过数量
	double money = 100000;
	while (true) {
		if (money > 50000) {//过路口 大于50000
			//money =money - money * 0.05;
			money *= 0.95;//打95折呗，一次收%5不就是95折吗？
			 count++;
		} else if (money >= 1000) {//过路口 大于 1000
			money -= 1000; 
			count++;
		} else { //钱不够了
			break;
		}
	}
	System.out.println("过了"+count+"次");


}}