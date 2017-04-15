package com.bruce.java;

/**
 * Created by qizhenghao on 17/4/13.
 */
public class TestArray {

    public static void main(String[] args) {

        int[] intArr = new int[Integer.MAX_VALUE];
        System.out.println(intArr.length);

        char[] charArr = new char[Integer.MAX_VALUE];
        System.out.println(charArr.length);

        byte[] byteArr = new byte[Integer.MAX_VALUE];
        System.out.println(byteArr.length);
    }
}
