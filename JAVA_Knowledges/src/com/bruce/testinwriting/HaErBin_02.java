package com.bruce.testinwriting;

import java.util.Arrays;

public class HaErBin_02 {

	/**
	 * @param args
	 *            2、有一组随机排列的字母数组，请编写一个时间复杂度为O(n)的算法，使得这些字母安装字母从小到大顺序排好。
	 *            说明：字母区分大小写，相同的字母，排序后小写排在大写前。 例如：R,B,B,b,W,W,B,R,B,w
	 *            排序后：b,B,B,B,B,R,R,w,W,W 1)描写思路（2分） 2）请用你熟悉的编程语言编写代码实现（8分）
	 * 
	 *            思路：空间换时间，把52个字母映射为52个数字，并记录出现的次数，然后迭代输出
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// A=65,Z=90 a=97,z=122
		char[] src = { 'R', 'B', 'B', 'b', 'W', 'W', 'B', 'R', 'B', 'w' };
		sort(src);
		System.out.println(Arrays.toString(src));
	}

	private static void sort(char[] src) {
		int[] items = new int[52];

		for (int i = 0; i < src.length; i++) {
			if ('z' > src[i] && src[i] > 'a') {
				items[(src[i] - 'a') * 2]++;
			}
			if ('Z' > src[i] && src[i] > 'A') {
				items[(src[i] - 'A') * 2 + 1]++;
			}
		}

		int index = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i] != 0) {
				if (i % 2 == 0) {
					for (int j = 0; j < items[i]; j++) {
						src[index++] = (char) (i / 2 + 'a');
					}
				} else {
					for (int j = 0; j < items[i]; j++) {
						src[index++] = (char) (i/2 + 'A');
					}

				}
			}
		}
	}

}
