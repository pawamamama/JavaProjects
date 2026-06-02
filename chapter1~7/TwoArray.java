public class TwoArray {
    public static void main(String[] args) {
        int arr[][] = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0}
        };
        //二维数组每一行都是一个单独的一维数组要得到行数，要用arr[i].length来进行访问
        
        int len = arr.length;
        
        // 输出二维数组
        for (int i = 0; i < len; i++) { // 控制行
            for (int j = 0; j < arr[i].length; j++) { // 控制每行的列数
                System.out.print(arr[i][j] + " "); // 输出时加空格更清晰
            }
            System.out.println(); // 换行
        }
    }
}