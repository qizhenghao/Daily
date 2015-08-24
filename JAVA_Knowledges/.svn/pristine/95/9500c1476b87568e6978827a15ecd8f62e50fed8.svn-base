package com.bruce.testinwriting;

import java.util.Arrays;

public class YourTimes {

	/**
	 * @param args
	 *            尝试在以下文本中搜索并打印出包含单词"your"(不区分大小写)的句子，并按照出现次数从高到低排序 Make
	 *            yourself at home None of your business I will be more careful
	 *            How about going to a move? Your life is your own affair
	 *            思路：先统计每个字符串句子中包括“your”的个数，然后按个数排序
	 */
	public static void main(String[] args) {

		String key = "your";
		String[] input = { "Make yourself at home", "None of your business",
				"I will be more careful", "How about going to a move?",
				"Your life is your own affair" };

		int[] times = { 0, 0, 0, 0, 0 };

		countTime(input, times, key);
		System.out.println(Arrays.toString(times));
		quickSort(input, times, 0, input.length - 1);
		System.out.println(Arrays.toString(input));
	}

	private static void quickSort(String[] input, int[] times, int low, int high) {
		int index = high;
		int newIndex = low - 1;

		if (low > high) {
			return;
		}

		for (int i = low; i < high; i++) {
			if (times[i] < times[index]) {
				newIndex++;
				swap(input, times, i, newIndex);
			}
		}
		swap(input, times, high, newIndex + 1);

		quickSort(input, times, low, newIndex);
		quickSort(input, times, newIndex + 2, high);

	}

	private static void swap(String[] input, int[] times, int i, int newIndex) {

		times[i] = times[i] + times[newIndex];
		times[newIndex] = times[i] - times[newIndex];
		times[i] = times[i] - times[newIndex];

		String temp = input[i];
		input[i] = input[newIndex];
		input[newIndex] = temp;
	}

	private static void countTime(String[] input, int[] times, String key) {
		key = key.toUpperCase();
		for (int i = 0; i < times.length; i++) {
			String[] strArr = input[i].toUpperCase().split(" ");
			for (int j = 0; j < strArr.length; j++) {
				if (strArr[j].contains(key)) {
					times[i]++;
				}
			}
		}
	}

}
