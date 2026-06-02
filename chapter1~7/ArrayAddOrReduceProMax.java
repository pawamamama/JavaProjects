import java.util.Scanner;//表示把java.util包下的类导入到文件
public	class ArrayAddOrReduceProMax{
	public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in);//创建Scanner对象接收用户输入
		int arr[] = {1,2,3};//定义初始数组
		do{
  			int newElement = 0;
			int changeSize = 0;//扩容和缩减值初始为零
			int len = arr.length;//获取数组当前长度（扩容或缩减后）
			System.out.println("添加数值/缩减刚才的数值/缩减末尾//退出 （y/r/n）");
				char picking = myScanner.next().charAt(0);
				String myString = " ";
				if ( 'n' == picking ) {
					break;//跳出程序
				 } else if (picking == 'y') {//扩容
                 changeSize = 1;
                 myString = "扩容";
                 System.out.println("输入你要添加的元素");
                 newElement = myScanner.nextInt();
                 } else if (picking == 'r') {//缩减
                 changeSize = -1;

                if (len <= 1) {
                    System.out.println("无法继续缩减");
                    continue;
                }
                  myString = "缩减";
                 } else {
                 System.out.println("非法输入");
                 continue;//跳出本次
                 }    
			int lenNew = len +changeSize ;//每次扩容和缩减设计为 接收一个扩容值和缩减值changeSize由if判断决定
			int arrNew[] = new int[lenNew];//创建new数组接收新值or 缩减
            int lenSum = (changeSize == 1) ? len : len - 1;//

				for (int i = 0;i < lenSum;i++ ) {
					arrNew[i] = arr[i];//拷贝arr的元素到new数组 
				}
				if (changeSize == 1) { 
				    // 扩容操作：在新数组最后一个位置添加新元素
				    arrNew[lenNew - 1] = newElement;
				}

				// 无论扩容还是缩减，都让 arr 指向新数组
				// 本质：用新数组替换旧数组（旧数组等待垃圾回收）
				arr = arrNew;

				System.out.println("-------" + myString + "后的情况------");

				// 输出当前数组内容（注意：必须用 arr.length，因为 arr 已经更新）
				for (int i = 0; i < arr.length; i++) {
				    System.out.print(arr[i] + "\t");
				}
				
		  }while(true);

	}
}
