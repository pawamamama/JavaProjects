public class TwoArraySum{
    public static void main(String[] args) {
        int arr[][] = {
            {1, 2,},
            {44, 5, 55, 11, 3},
            {0,1,1,3}
        };
        //二维数组每一行都是一个单独的一维数组要得到行数，要用arr[i].length来进行访问
        int len = arr.length;
        int sum = 0;
        // 输出二维数组
        for (int i = 0; i < len; i++) { // 控制行
            for (int j = 0; j < arr[i].length; j++) { // 控制每行的列数
                sum += arr[i][j];  

                
            }
        }
        System.out.println("sum = "+sum);
    }
}