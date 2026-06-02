public	class method02{
	public static void main(String[] args){
	//遍历一个数组，输出数组的各个元素值
	int [][] map = {{0,0,1},{1,1,1},{1,1,3}};
	//直接遍历,当多次遍历的话 会有很多冗余代码 
	/*for (int i = 0;i < map.length;i++ ) {
		for (int j = 0;j < map[i].length ;j++ ) {
			System.out.print(map[i][j] + " ");
		}
 		System.out.println();	
	}
	*/
	//解决方案是写成方法 
	//定义一个类MyTools,写一个成员方法调用一下

	//使用方法完成输出
	//使用MyTools创建一个对象 
	MyTools tool = new MyTools();
	//调用方法打印map数组
	tool.printArr(map);
	//好处是可以多次调用 多次使用 
	//封装化 想改的时候直接可以到方法去改 不用多次去改
	tool.printArr(map);
	tool.printArr(map);
	tool.printArr(map);
	tool.printArr(map);
	tool.printArr(map);
	tool.printArr(map);


	}
}



class MyTools {
	//方法接受一个二维数组
	public void printArr(int [][] map) {
		//对传入的map数组进行遍历输出
	for (int i = 0;i < map.length;i++ ) {
		for (int j = 0;j < map[i].length ;j++ ) {
			System.out.print(map[i][j] + " ");
		}
 		System.out.println();	
	}
	}

}
