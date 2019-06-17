package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class TestCase {

	public static void main(String[] args) {
		firstAndSencodUpToLow();
	}
	/**
	 * 前两个字母大写转小写
	 */
	public static void firstAndSencodUpToLow() {
		BufferedReader br= null;
		PrintWriter pw = null;
		String fileName = "test";
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("test2")));
			String lineMessage = "";
			while((lineMessage = br.readLine())!=null){
				char first = lineMessage.charAt(0);
				char second = lineMessage.charAt(1);
				if(first>='A' && first<='Z'){
					lineMessage = exchange(lineMessage,first,0,1);
				}
				if(second>='A' && second<='Z'){
					lineMessage = exchange(lineMessage,second,1,2);
				}
				pw.write(lineMessage+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static String exchange(String lineMessage,char c,int start,int end){
		c = (char) (c+32);
		StringBuffer sb = new StringBuffer(lineMessage);
		lineMessage = new String(sb.replace(start, end, c+""));
		return lineMessage;
	}

}