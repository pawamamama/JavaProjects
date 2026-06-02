public	class BubbleSort{
	public static void main(String[] args){
	int arr[] = {1,2,15,22};
	int len = arr.length-1;
int temp = 0;
int a = 0;
for (int i = 0;i < len ;i++ ) {
	for (int j = 0;j < len - i ; j++  ) {
	//如果前面的数>后面的数，就交换
		if (arr[j] > arr[j+1]) {
			temp = arr[j];
			arr[j] = arr[j+1];
			arr[j+1] = temp;
			a = 1;
		}	
	}
	if (a == 0) {//如果没交换就说明一开始就是有序数组
		System.out.println("一开始就是有序数组");
		break;
	}
}
	
	for (int i = 0;i < arr.length;i++) {
		System.out.print(arr[i] + "\t" );
		        }



	}
}