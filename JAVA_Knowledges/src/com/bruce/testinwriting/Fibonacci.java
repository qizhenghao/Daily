package com.bruce.testinwriting;

import java.util.StringTokenizer;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(fibonacci(10));
		System.out.println(fibonacci(9));
		System.out.println(fibonacci(8));
		System.out.println(fibonacci(7));
		System.out.println(fibonacci(6));
		System.out.println(fibonacci(5));
		
	}
	
	public static int fibonacci(int n) {
		if(n==0 || n==1) {
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	

}
