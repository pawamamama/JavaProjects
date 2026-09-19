package com.pawamamama.homework;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 此类用于演示关于流的读写方法
 *
 */
public class StreamUtils {
	/**
	 * 功能：将输入流转换成byte[]
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public static byte[] streamToByteArray(InputStream is) throws Exception{
		// 创建一个内存中的字节输出流（缓冲区流），用于临时存放从输入流读取到的所有数据
		// 它内部维护一个可自动扩容的 byte[]，数据写在内存里，不涉及磁盘
		ByteArrayOutputStream bos = new ByteArrayOutputStream();//创建输出流对象
		byte[] b = new byte[1024];//字节数组
		int len;
		while((len=is.read(b))!=-1){//循环读取，每次1024kb
			bos.write(b, 0, len);//读取到的数据写入bos
		}
		byte[] array = bos.toByteArray();//然后一次性把将bos转换成byte数组
		bos.close();//关闭流
		return array;//返回字节数组
	}
	/**
	 * 功能：将InputStream转换成String
	 * @param is
	 * @return
	 * @throws Exception
	 */
	
	public static String streamToString(InputStream is) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder builder= new StringBuilder();
		String line;
		while((line=reader.readLine())!=null){ //当读取到 null时，就表示结束
			builder.append(line+"\r\n");
		}
		return builder.toString();
		
	}

}
