                                                                                                                                                                                                
    	T fdw = new T();
    	//出迷宫
    	//1.创建迷宫
    	//2.规定 map 数组的元素值 : 0表示可以走，1表示障碍物 
    	int[][] map = new int [8][7];
    	//3.将上下两行和最下面的一行全部设置为1（迷宫边界）
    	for (int i = 0;i < 7;i++) {
    		map[0][i] = 1;
    		map[7][i] = 1;
    	}
    	for (int i = 0;i < 8;i++) {

    		map[i][0] = 1;
    		map[i][6] = 1;
    	}
    	//设置地图障碍物
    	map[3][1] = 1;
    	map[3][2] = 1;
    	map[2][2] = 1;//测试回溯
    	fdw.findWay(map,1,1);//找路
    	tools.printArr(map);


    }
}
class MyTools {
	//方法接受一个二维数组
	public void printArr(int [][] map) {
		//对传入的map数组进行遍历输出\
			System.out.println("-------map地图找路情况-------");
	for (int i = 0;i < map.length;i++ ) {
		for (int j = 0;j < map[i].length ;j++ ) {
			System.out.print(map[i][j] + " ");
		}
 		System.out.println();	
	}
	}

}
class T {
	//使用递归回溯的思想解决老鼠出迷宫

	//1.此方法用于找出迷宫的路径 出迷宫的路线
	//找到了返回true 没找到返回false
	// map 就是 迷宫
	// int i j 是老鼠当前在哪个位置 初始位置
	// 因为我们是递归的找路，所以我们需要找到退出递归的条件 
	// 规定 0表示可以走  1障碍物 2表示可以走 3 表示走过 ，但是走不通死路
	//当 map[6][5] = 2 就说明找到通路，否则就继续找
	//找路策略 下->右->上->左-> 
	public boolean findWay(int[][] map ,int i , int j ) {
		if (map[6][5  ] == 2) {//说明已经找到路了 
			return true;
		} else {
			if (map[i][j] == 0) {//说明在初始点位，但是还没走 
				//假定可以走先设置成2
				map[i][j] = 2;
				//开始寻路,确定该位置上下左右相邻格到底能不能走通，形成一条路 
				if (findWay(map,i + 1,j) ) {//先下
					return true;
				} else if (findWay(map,i,j + 1)) {//右
					return true;
				} else if (findWay(map,i - 1,j)) {//上
					return true;
				} else if (findWay(map,i,j - 1)) {//左
					return true;
				}else {
					map[i][j] = 3; //走过走不通
					return false;//这个点四个方向都失败，我放弃它
				}
			} else {//map[i][j] = 1,2, 3 障碍， 走过的 ，走过的但是走不通的  那就停止递归 开始 回溯
				return false;//不要走
			}
		}
	}
}