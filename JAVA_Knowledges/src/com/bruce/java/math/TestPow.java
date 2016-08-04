package com.bruce.java.math;

/**
 * Created by qizhenghao on 16/6/21.
 */
public class TestPow {

    public static void main(String[] args) {
        double sumPrice = 8864 * 78.94d;
        double monthRate = 4.9d/100/12;
        double monthCount = 15*12;

        double everyMonthPay = 480000 * monthRate * (Math.pow((1 + monthRate), monthCount) / ((Math.pow((1 + monthRate), monthCount) - 1)));

        System.out.println(everyMonthPay);

        float f1 = (float) Math.pow(1.005, 360);

        System.out.println(f1);
    }
}
