import java.util.Scanner;//表示把java.util包下的类导入到文件
public	class ArrayAdd{
	public static void main(String[] args){
		//数组扩容
		Scanner myScanner = new Scanner(System.in);//创建Scanner对象接收用户输入
		int arr[] = {1,2,3};//定义初始数组
		do{
			int len = arr.length;//获取初始数组的长度和每次取扩容后的长度
			int lenNew = len + 1;//每次扩容设计为 +1
			int arrNew[] = new int[lenNew];//创建扩容数组接收新值
				for (int i = 0;i < len ;i++ ) {
					arrNew[i] = arr[i];//拷贝arr的元素到扩容数组 
				}
				System.out.println("输入你要添加的元素");
				arrNew[lenNew-1] = myScanner.nextInt();
				/*len = 3
				arrNew = 4个元素
				下标是 0~3
				所以是 arrNew[3],就是lenNew-1*/
				arr =arrNew;//New让arr指向 arrNew,旧数组销毁
				 System.out.println("-------扩容后的情况------");
				//输出扩容后的数组,不用len是因为扩容过了不适用
				for (int i = 0;i < arr.length;i++) {
				System.out.print(arr[i] + "\t" );
		        }
				System.out.println("是否继续添加y/n");
				char picking = myScanner.next().charAt(0);//获取一个字符
				if ('n'== picking) {
					break;//跳出程序
				 } else if (picking != 'y') {//等于y直接跳过，进行下一次扩容
                    System.out.println("非法字符");
                 }
		  }while(true);

		   System.out.println("你退出了添加------");
	}
}
