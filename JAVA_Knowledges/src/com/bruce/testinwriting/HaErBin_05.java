package com.bruce.testinwriting;

import java.util.Arrays;

public class HaErBin_05 {

	/**
	 * @param args
	 *            请实现方法：print_rotate_matrix(int[] matrix, int n),
	 *            将一个n×n二维数组逆时针旋转45度后打印，例如，下图显示一个3×3的二维数组及其旋转后屏幕输出的效果。
	 */
	public static void main(String[] args) {

		int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		
		print_rotate_matrix(arr, 3);
	}

	private static void print_rotate_matrix(int[][] arr, int n) {
		int row = n+(n-1);
		int col = n;
		int mid = row/2;
		int [][] res = new int[row][col];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				res[mid-j][j] = arr[j-i][j];
			}
			
		}
				
		for (int i = 0; i < row; i++) {
			if (i<=mid) {
				for (int j = 0; j <= i; j++) {
					System.out.print(res[i][j] + " ");
				}
			} else {
				for (int j = 0; j <= row-1-i; j++) {
					System.out.print(res[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

}
