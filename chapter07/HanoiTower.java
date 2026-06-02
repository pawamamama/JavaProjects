public class HanoiTower {
    public static void main(String[] args) {
    Tower t = new Tower();
    t.move(8 ,'A','B','C');



    }
}

class Tower {
	//
	//num 表示要移动的个数
	// a,b,c 表示A塔 B塔 C塔
	//简化思路
	public void move(int num ,char a, char b ,char c) {

    if (num == 1) {//一个盘子的情况 a直接到
    	System.out.println(a + "->" + c );
    }else {//多个盘子，探讨两个
    	//把n-1个就是顶盘（在a柱）移动到b 要通过c进行间接
    	move(num - 1,a,c,b);
    	//接下来把底盘（在a柱子）移动到c
    	System.out.println(a + "->" + c );
    	//然后把b柱子里的所有盘子移动到c 借助 a
    	move(num -1,b,a,c);
    }
	} 
}