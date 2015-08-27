package com.bruce.bitoperation;

/**
 * Created by qizhenghao on 15-8-26.
 */
public class TestBit {

    private static final int MODE_SHIFT = 30;
    private static final int MODE_MASK  = 0x3 << MODE_SHIFT;

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(MODE_MASK));
        System.out.println(Integer.toBinaryString(~MODE_MASK));
        System.out.println(Integer.toBinaryString(MODE_MASK & ~1));
        System.out.println(Integer.toBinaryString(MODE_MASK | ~1));

        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1.equals(obj1));
        System.out.println(obj1.equals(obj2));
        obj2 = obj1;
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1==obj2);


    }
}
