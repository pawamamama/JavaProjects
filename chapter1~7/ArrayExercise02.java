public	class ArrayExercise02{
	public static void main(String[] args){
		//求出一个数组int[]的最大值
		// //自己写法，综合给到拉完了
		// int[] arr = {4,-1,9,10,23,10101,111,1222,111111,99999};
		//  int bigNumber = 0;
		//  int maxIndex = 0;
		//  for (int i = 0;i < arr.length;i++ ) {
		//  	if ((arr.length-1) != i) {
		//  		if (arr[i] < arr[i+1]) {
		//  			bigNumber = arr[i+1];
		//  		    maxIndex = i+1;
		//  	}else {
		//  			bigNumber = arr[i];
		//  	}		 maxIndex = i;
		//  	}
	 	
		//  }
		//  	System.out.println("最大的的元素数值为"+bigNumber+"下标为"+maxIndex);
		int[] arr = {4,-1,9,10,23,10101,111,1222,111111,99999};
		int max = arr[0];//假定第一个元素是最大值
		int maxIndex = 0;
		  for (int i = 0;i < arr.length;i++ ) {//从下标一开始遍历arr
		  	if (max < arr[i]) {//如果max < 当前元素
		  		max = arr[i];   //吧max设置成当前元素
		  		maxIndex = i;
		  	}
		  }
		  //当我们遍历完，max就是最大值
		  System.out.println("最大的的元素数值为"+max+"下标为"+maxIndex);
	 }
	}