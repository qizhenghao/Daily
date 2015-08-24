package com.bruce.testinwriting;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class SubString {

	/**
	 * @param args
	 *            编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
	 *            但是要保证汉字不被截半个，如"我ABC"4，应该截为
	 *            "我AB"，输入"我ABC汉DEF"，6，应该输出为"我ABC"而不是"我ABC+汉的半个"。
	 */
	public static void main(String[] args) {

		String orgin = "我ABC汉DEF";
		int length = 66;
		
		System.out.println(orgin.length());
		
		System.out.println("" + subString(orgin, length));
		System.out.println("" + subString(orgin, length+1));
		System.out.println("" + subString(orgin, length-1));
		
	}

	private static String subString(String orgin, int length) {

		if(null == orgin || "".equals(orgin) || length<1) {
			return "";
		}
		
		if(length>strLength(orgin)) {
			return orgin;
		}
		
		StringBuilder builder = new StringBuilder();
		int i = 0;
		for (; i < length; i++) {
			if(!isLetter(orgin.charAt(i))) {
				length--;
			} 
			builder.append(orgin.charAt(i));
		}
		
		return builder.substring(0, length);
	}

	private static int strLength(String orgin) {
		int length = 0;
		for (int i = 0; i < orgin.length(); i++) {
			length++;
			if (!isLetter(orgin.charAt(i))) {
				length++;
			}
		}
		return 0;
	}

	private static boolean isLetter(char charAt) {
		int k = 0X80;
		return charAt/k==0?true:false;
	}

}
