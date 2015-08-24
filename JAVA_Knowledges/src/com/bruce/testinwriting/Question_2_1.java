package com.bruce.testinwriting;

import java.util.Arrays;

public class Question_2_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arrInt = {24,8,12,20,4,36,28,14};
		
		
		int maxDivisor = getMaxDivisor(arrInt[0], arrInt[1]);
		for(int i=2;i<arrInt.length;i++) {
			maxDivisor = getMaxDivisor(maxDivisor, arrInt[i]);
		}
		System.out.println(maxDivisor);
		
		
		int minMultiple = 1;
		for(int i=0;i<arrInt.length;i++) {
			minMultiple = minMultiple * arrInt[i] / getMaxDivisor(minMultiple, arrInt[i]);
		}
		System.out.println(minMultiple*maxDivisor);
		
	}


	private static int getMaxDivisor(int i, int j) {
		if(i>j) {
			i = i + j;
			j = i - j;
			i = i - j;
		}
		while(j%i != 0){
			int temp = j;
			j = i;
			i = temp%i;
		}
	    return i;
	}
}
