package com.bruce.testinwriting;

import java.util.Arrays;

public class HaErBin_03 {

	/**
	 * @param args
	 *            3、给定N个磁盘，每个磁盘大小为D[i]，i=0,…N-1。现要在这N个磁盘上“顺序分配”M个分区。每个分区大小为P[j]，
	 *            j=0,…M-1。顺序分配的意思是：分配一个分区P[j]时，如果当前磁盘剩余空间足够，则在当前磁盘分配;如果不够，
	 *            则尝试下一磁盘
	 *            ，直到找到一个磁盘D[i+k]可以容纳该分区。分配下一个分区P[j+1]时，则从当前磁盘D[i+k]的剩余空间开始分配
	 *            ，不再使用D
	 *            [i+k]之前磁盘的未分配空间。如果这M个分区不能在这N个磁盘完全分配。则认为分配失败。请实现函数is_allocable
	 *            判断给定N个磁盘(数组D)和M个分区(数组P),是否会出现分区分配失败的情况。
	 * 
	 *            举例：磁盘为[120,120,120]，分区为[60,60,80,20,80]可分配，如果为[60,80,80,20,80]
	 *            ，则分配失败。
	 */
	public static void main(String[] args) {
		int D[] = {120,120,120};
		int D1[] = {120};
		int D2[] = {120,120};
		int D3[] = {12000};
		int D4[] = {12,36,500};
		int M1[] = {60,60,80,20,80};
		int M2[] = {60,80,80,20,80};
		
		System.out.println(is_allocable(D, M2));
		System.out.println(is_allocable(D1, M2));
		System.out.println(is_allocable(D2, M2));
		System.out.println(is_allocable(D3, M2));
		System.out.println(is_allocable(D4, M2));
		
	}

	private static boolean is_allocable(int[] D, int[] M) {
		int beLast = 0;
		int index = 0;
		boolean bNext = true;
		for (int i = 0; i < D.length; i++) {
			beLast = D[i];
			bNext = true;
			for (int j = index; j < M.length && bNext; j++) {
				if (beLast >= M[j]) {
					beLast -= M[j];
				} else {
					index = j;
					bNext = false;
				}
			}
		}
		
		return bNext;
	}

	
}
