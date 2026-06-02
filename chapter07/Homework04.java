public class Homework04{

    public static void main(String[] args) {
    	int[] arr = {1,2,3,4,5};
    	T t1 = new T();
    	int[] arrNew = t1.copyArr(arr);
    	t1.printArrs(arr,arrNew);
    	}

}
class T { 

	public int[] copyArr(int[] arr) {
		int[] arrNew = new int[arr.length];
		for (int i = 0;i < arr.length ;i++ ) {
			arrNew[i] = arr[i];
		}
		return arrNew;
	}
	//用可变参数打印多个数组
	public void printArrs(int[]...arrs) {
		System.out.println("接收到了" + arrs.length + "个数组");
		for (int i = 0;i < arrs.length; i++ ) {
		System.out.println("打印第" + i + "个数组");
			for (int j = 0; j <arrs[i].length ; j++ ) {
				System.out.print (arrs[i][j] + "\t");
			}
	         	System.out.println();

		}
	}

}
