public	class Arrayreverse{
	public static void main(String[] args){
		//数组反转
		int arr[] = {1,2,333,4445,667,6,87,666,6666,23232};
		int len = arr.length;//计算数组的长度
		for (int i = 0;i < len / 2;i++) {//次数为长度/2 正好等于交换次数也不用关心奇偶数
			//arr [0] 和 arr[9]交换         10-1-0=9
		 	//arr [1] 和 arr[8]交换         10-1-1=8
		 	//arr[i] = arr[arr.length-1-i]  数组长度-1-i=尾行
		 	int tmp = arr[len - 1 - i];
			arr[len - 1 - i]=arr[i];//保存一个数值用于间接赋值
			arr[i] = tmp;
		}
			//输出，遍历数组
		for (int i = 0;i < len ;i++) {
			System.out.println(arr[i]);
		}
	}}