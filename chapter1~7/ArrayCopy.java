public	class ArrayCopy{
	public static void main(String[] args){
		//数组拷贝
		int arr1[] = {10,20,20};
		//创建一个新的数组arr2[],开辟新的数据空间
		int arr2[] = new int[arr1.length];
		//遍历arr1，每个元素拷贝到相应位置
		for (int i = 0;i < arr1.length;i++ ) {
			arr2[i]=arr1[i];
		}
		//修改arr2
		arr2[0] = 101010;
		System.out.println("--------arr1---------");
		//输出，遍历数组
		for (int i = 0;i < arr1.length ;i++) {
			System.out.println(arr1[i]);
		}
		System.out.println("--------arr2---------");
		//输出，遍历数组
		for (int i = 0;i < arr2.length ;i++) {
			System.out.println(arr2[i]);
		}
		//修改arr2不影响arr1，数组拷贝
		

	}
}