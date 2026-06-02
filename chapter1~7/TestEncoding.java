public class TestEncoding {
    public static void main(String[] args) throws Exception {
        System.out.println("请直接输入'男'然后回车: ");
        int firstByte = System.in.read();
        int secondByte = System.in.read();
        System.out.println("读取到的字节: " + firstByte + ", " + secondByte);
        System.out.println("对应的字符: " + (char)firstByte + (char)secondByte);
        
        // 清空缓冲区
        System.in.read(); // 读取回车
    }
}