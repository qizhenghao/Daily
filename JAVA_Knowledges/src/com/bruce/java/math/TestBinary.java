package com.bruce.java.math;

/**
 * Created by qizhenghao on 16/10/26.
 */
public class TestBinary {

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(-1 >> 1));
        System.out.println(Integer.toBinaryString(-1 >>> 1));
        System.out.println(Integer.toBinaryString(-1 << 1));
//        System.out.println(-1 << 1);
    }
}
