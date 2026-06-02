public	class Arrayreverse02{
	public static void main(String[] args){
		//数组反转02,逆序赋值方式
		int arr[] = {1,2,333,4445,667,6,87,666,6666,23232};
		int len = arr.length;//计算数组的长度
		int arr2[] = new int[len];
		//for循环内只能初始化同一种变量类型
		for (int i = len - 1,j = 0; i >= 0 ;i--,j++) {//逆序遍历，正序赋值给arr2
			//arr1[len-1-i]= arr2[i]
			arr2[j]= arr[i];
		}
		//完成后arr2就是一个逆序的数组
		//让arr 指向 arr2的数据空间
		arr = arr2;//这里传递的是元素空间的首地址，arr1原先代表的空间就没人使用了会被销毁
			//输出，遍历数组
		for (int i = 0;i < len ;i++) {
			System.out.println(arr[i]);
		}
	}
}