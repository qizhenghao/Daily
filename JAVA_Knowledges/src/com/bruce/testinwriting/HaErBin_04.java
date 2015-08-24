package com.bruce.testinwriting;

public class HaErBin_04 {

	/**
	 * @param args
	 *            4、给定整数x，定义函数A(n)=1+x+x2+x3+…+xn(n为整数且n>=0).已知乘运算的时间远大于加运算，输入x，
	 *            n;如何尽可能快的求出A(n)?
	 * 
	 *            要求：
	 * 
	 *            1)描述思路(2分)
	 * 
	 *            2)评估你的算法需要进行多少次乘法?(3分)
	 * 
	 *            3)请用你熟悉的编程语言编码实现(5分)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1;
		int n = 9;

		System.out.println(sum(x, n));
		System.out.println(sum1(x, n));
	}

	private static long sum1(int x, int n) {
		long temp = x + 1;
		for (int i = 0; i < n - 1; i++) {
			temp = temp * x + 1;
		}
		return temp;
	}

	private static int sum(int x, int n) {
		int sum = 1;
		int xNum = (1 + n) * n / 2;
		for (int i = 0; i < xNum; i++) {
			sum += x;
		}
		return sum;
	}

}
