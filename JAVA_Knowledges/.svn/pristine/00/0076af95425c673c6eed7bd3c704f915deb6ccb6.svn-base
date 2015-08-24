package com.bruce.testinwriting;

import java.util.Arrays;
import java.util.Random;

public class Matrix {

	/**
	 * @param args
	 *            一个10*10的矩阵（可以理解为棋盘），随时生成一组数据填入矩阵，任何一个位置的数字除4进行计算，按余数着色，
	 *            余数为0着色为red
	 *            ，1为blue，2为green，3为black，可以理解为生成4中颜色的棋子放入棋盘，如果存在其中同色五星连珠的情况
	 *            （规则通五子棋），找出任意一组，输出5个棋子的位置下标值
	 */
	public static void main(String[] args) {
		int[][] arr = new int[10][10];
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				arr[i][j] = random.nextInt(100) % 4;
			}
			System.out.println(Arrays.toString(arr[i]));
		}

	}

	public static boolean searchRight(int[][] arr, int i, int j) {

		return false;
	}

	public static boolean searchBeside(int[][] arr, int i, int j) {

		return false;
	}

	public static boolean searchRightBeside(int[][] arr, int i, int j) {

		return false;
	}

	public static boolean searchLeftBeside(int[][] arr, int i, int j) {

		return false;
	}

	public static boolean isSame(int i, int j) {
		if (i == j) {
			return true;
		}
		return false;
	}
}
