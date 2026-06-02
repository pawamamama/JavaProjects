public	class Stars {
public static void main(String[] args){
// 	//空心金子塔
// 	行数(i)  空格数   星号数   输出结果
// 0        4        1           *
// 1        3        3          ***
// 2        2        5         *****
// 3        1        7        *******
// 4        0        9       *********
//星号数 = 2*层数-1

	int rows = 100;//总行数
	for (int i = 1;i <= rows  ;i++ ) {//控制层数
		//空格输出 
		for (int k = 1;k <= rows - i;k++ ) {//总层数-当前曾
			System.out.print(" ");
		}
		//*号输出
		for (int j = 1;j <= (2*i-1) ;j++ ) {//金字塔*数 是 2*层数-1 
		//空心判断
		if ((j == 1 || j == (2*i-1))|| i == rows ) {//底行判断
		  		System.out.print("*");
		  }else {
		  		System.out.print(" ");
		  } 
			
		}
			System.out.print("\n");
			
		
	}
 
	}}
  