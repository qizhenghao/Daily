package com.bruce.java.math;

/**
 * Created by qizhenghao on 15-11-9.
 */
public class TestNumFormat {

    public static long currentTime = System.currentTimeMillis();

    public static void main(String[] args) {

        long l1 = 111119;
        long l3 = 111115;
        long l4 = 111116;

//        System.out.println(Long.toBinaryString(l1));
//        long n1 = l1 <<59;
//        System.out.println(Long.toBinaryString(n1));
//        long n2 = n1 >>59;
//        System.out.println(n2);
        currentTime = System.currentTimeMillis();
        for (long i=0;i<1000000000;i++) {//500ms 去掉后440ms
            isUserIdTailNum_7_Or_9(l4);
        }
        System.out.println("no : " + (System.currentTimeMillis() - currentTime));

//        currentTime = System.currentTimeMillis();
//        for (long i=0;i<100000000;i++) {//52ms
//            isUserIdTailNum_7_Or_9(l3);
//        }
//        System.out.println("no : " + (System.currentTimeMillis() - currentTime));
//
//        currentTime = System.currentTimeMillis();
//        for (long i=0;i<1000000000;i++) {//450ms 去掉后421
//            isUserIdTailNum_7_Or_9(l1);
//        }
//        System.out.println("7or9 : " + (System.currentTimeMillis() - currentTime));



//
//        double angle = 360 * 1.0 * 1129 / 2000;
//        System.out.println(angle);
//        System.out.println(Math.cos(angle));
//        System.out.println(150 * Math.cos(0.3708) - 150);
//        System.out.println(150 * Math.cos(1.1016) - 150);
//        System.out.println(150 * Math.cos(1.7244) - 150);
//        System.out.println(Math.cos(1));
//        System.out.println(Math.cos(0.1));
//        System.out.println(Math.cos(1.1));
//        System.out.println(Math.cos(0));
//        System.out.println(Math.cos(45/180));

    }

    public static boolean isUserIdTailNum_7_Or_9(long userId) {
        if ((userId & 1) != 0) {
            long tailNum = userId%10;
            if (tailNum == 7 || tailNum == 9) {
                return true;
            }
        }
        return false;
    }
}
