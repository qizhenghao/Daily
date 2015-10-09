package com.bruce.utils;

/**
 * Created by qizhenghao on 15-9-15.
 */
public class TestUtils {

    public static void main(String[] args) {

//        long testMils1 = 19*60*60*1000 + 30*60*1000;
//        long testMils2 = 19*60*60*1000;
//        System.out.println(TimeUtils.isSameDayOfMillis(System.currentTimeMillis()-100000, System.currentTimeMillis()));
//        System.out.println(TimeUtils.isSameDayOfMillis(System.currentTimeMillis()-1000000, System.currentTimeMillis()));
//        System.out.println(TimeUtils.isSameDayOfMillis(System.currentTimeMillis()-10000000, System.currentTimeMillis()));
//        System.out.println(TimeUtils.isSameDayOfMillis(System.currentTimeMillis()-testMils1, System.currentTimeMillis()));
//        System.out.println(TimeUtils.isSameDayOfMillis(System.currentTimeMillis()-testMils2, System.currentTimeMillis()));

        long testMils3 = 3*60*60*1000 + 59*60*1000;
        long testMils4 = 19*60*60*1000;
        System.out.println(TimeUtils.isMoreThanHours(System.currentTimeMillis()-testMils3, System.currentTimeMillis(), 4));
        System.out.println(TimeUtils.isMoreThanMinutes(System.currentTimeMillis()-61*1000, System.currentTimeMillis(), 1));
        System.out.println(TimeUtils.isMoreThanMinutes(System.currentTimeMillis()-59*1000, System.currentTimeMillis(), 1));
    }
}
