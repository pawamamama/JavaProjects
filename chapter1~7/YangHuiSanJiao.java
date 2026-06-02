public class YangHuiSanJiao{
    public static void main(String[] args) {
        //杨辉三角
        int[][] arr = new int[10][];


        // 输出二维数组
        for (int i = 0; i < arr.length; i++) { // 控制行
                //给每个一维数组(行)开辟空间，
                //二维数组本质是好几行一维数组，
   //赋值
                 arr[i] = new int[i+1];
            for (int j = 0; j < arr[i].length; j++) { // 控制每行的列数
                
                if (j == 0 || j == arr[i].length-1) {//首尾为一
                    arr[i][j] = 1;
                }else {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1]; 
                }
                
            }
        }
        // 输出杨辉三角
        for (int i = 0; i < arr.length; i++) { // 控制行
            for (int j = 0; j < arr[i].length; j++) { // 控制每行的列数
                System.out.print(arr[i][j] + " "); // 输出时加空格更清晰
            }
            System.out.println(); // 换行
        }
    }
}