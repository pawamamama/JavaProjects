public	class ProcessControlHomeWork06{//流程控制作业06
public static void main(String[] args){
	int count = 0;
	for (int i = 1;i <= 100;i++ ) {
		if (i % 5 != 0) {
			//每5个一行，使用计数器count%5就说明要换行
			System.out.print(i);
			count++;
		}
		if (count % 5 == 0) {
			System.out.print("\n");
		}
	}
}
}