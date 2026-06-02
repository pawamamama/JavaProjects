import java.util.Scanner;//表示把java.util包下的类导入到文件
public	class TwoArrayHw04{
	public static void main(String[] args){
		//已知有一个升序数组
		//要求添加一个元素之后该元素依然是升序数组 
		//缩减输入过的值，具有记忆功能，当存储的读取完就开始缩减
		//可以还缩减尾行
		//先定义原数组
		int [] arr = {10,12,13,14};
		Scanner myScanner = new Scanner(System.in);
	do {
		int len = arr.length;
		int changeSize = 0 ;//添加+1和缩减-1状态值
		int insertSum = 0;//添加的数值
		int index = -1;//要操作的位置
		System.out.println("添加数值/缩减末尾//退出 （y/r/n）");
		char picking = myScanner.next().charAt(0);
		String myString = " ";
		if ( 'n' == picking ) {
			break;//跳出程序
		 } else if (picking == 'y') {//扩容
         changeSize = 1;
         myString = "扩容";
         System.out.println("输入你要添加的元素");
          insertSum = myScanner.nextInt();
         } else if (picking == 'r') {//缩减
         changeSize = -1;
         index = len;//缩减尾行

        if (len <= 1) {
            System.out.println("无法继续缩减");
            continue;
        }
          myString = "缩减";
         } else {
         System.out.println("非法输入");
         continue;//跳出本次
         }
    
 		//查找arr数组要添加的下标 ，如果发现了 insertSum <= arr[mid] 说明就是要查找的位置
		for (int i = 0;arr[i] >= len;i++ ) {
			index = i;
			break;
			}
		 // 创建一个新数组
		// 删除操作使用 index 获取目标值
		int lenNew = len + ((changeSize == 1) ? 1 : -1);
		int[] arrNew = new int[lenNew];
		for (int i = 0, j = 0; i < lenNew; i++) {
		    if (changeSize == 1) { // 插入
		        // 先跳过要插入的数值，然后要把跳过的数值赋值给下一次循环时的变量
		        if (i == index) {
		            arrNew[i] = insertSum; // 插入值，跳过一次 j 赋值
		        } else {
		            arrNew[i] = arr[j];
		            j++;
		        }
		    } else { // 删除
		        if (j == index) { // 跳过删除元素
		            j++;
		        }
		        arrNew[i] = arr[j];
		        j++;

		    }
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