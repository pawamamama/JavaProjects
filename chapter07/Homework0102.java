// 主类（程序入口）
public class Homework0102{

    public static void main(String[] args) {
    	//第一题
    	A01 a =  new A01();
    	double[] arr = {};//分配空间了但是arr.length是0
    	//double[] arr = null;//置空,没用空间arr .length直接报错
    	Double res = a.max(arr);
    	if (res != null) {//真的有最大值
    		System.out.println(res);
    	}else {
    		System.out.println("传入的数组有误,数组不能为null,或者{}");
    		
    	}
  
    	//第二题
    	String[] names = {"Alice", "Bob", "Charlie"};
    	A02 a02 =  new A02();
    	int ispass = a02.find(names,"Bob");
    	if (ispass != -1) {
    			System.out.println("查找到了 索引为 " + ispass);
    	} else {
    			System.out.println("没找到");
    	}
        
    }
}
 class A01 {
 	public Double max(double[] arr) {//Double包装类，可以反回null，应用场景是 需要返回没有的时候 
 	if (arr != null && arr.length > 0) { //代码健壮性
    // 判断数组不为 null 且至少包含一个元素，避免空指针异常并保证后续操作安全
 			double  max = arr[0];//假定最大值 
	 		for (int i = 1;i < arr.length ;i++ ) {
	 			if (max < arr[i]) {
	 				max = arr[i];
	 			}
 			}
 				return max;	//有最大值
 		} else {
 			return null;//没有最大值返回null 
 		}
 		
 	}
 }
 class A02 {
 	public int find(String[] str,String goal) {
 		/*int tmp = -1;
 		for (int i = 0;i < str.length;i++ ) {
 			if (str[i].equals(goal)) {
 			 	tmp = i;
 			}
 		}
 		return tmp;*/

 		for (int i = 0;i < str.length;i++ ) {
 			if (str[i].equals(goal)) {
 			 	return i;
 			}
 		}
 		return -1;//遍历完了还是没找到那就直接返回-1
 	} 
 }