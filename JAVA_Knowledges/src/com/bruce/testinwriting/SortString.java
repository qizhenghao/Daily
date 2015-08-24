package com.bruce.testinwriting;

import java.util.Arrays;

public class SortString {

	/**
	 * @param args
	 *            已知字母序列【d, g, e, c, f, b, o, a】， 请实现一个函数针对输入的一组字符串 input[] =
	 *            {"bed", "dog", "dear", "eye"}，按照字母顺序排序并打印。
	 */
	public static void main(String[] args) {

		String sorted = "dgecfboa";
		String[] input = { "bed", "dog", "dear", "eye" };

		sortString(input, 0, input.length-1, sorted);
		System.out.println(Arrays.toString(input));
	}

	private static void sortString(String[] input, int low, int high,
			String sorted) {
		int index = high;
		int newIndex = low - 1;
		if(low > high) {
			return;
		}
		
		for(int j=low;j<high;j++) {
			char c1 = input[j].charAt(0);
			char c2 = input[index].charAt(0);
			if (sorted.indexOf(c1) < sorted.indexOf(c2)) {
				newIndex++;
				swap(input, j, newIndex);
			}
		}
		swap(input, newIndex+1, high);
		
		sortString(input, low, newIndex, sorted);
		sortString(input, newIndex+2, high, sorted);
	}

	public static void swap(String[] input, int i, int j) {
		String temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	
	

}
