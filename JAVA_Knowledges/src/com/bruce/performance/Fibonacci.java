package com.bruce.performance;

/**
 * Created by qizhenghao on 15-11-27.
 */
public class Fibonacci {

    public static final int N = 40;

    public static long times = 0;

    public static void main(String[] args) {
        long lastTime = System.currentTimeMillis();
        long result = original(N);
        long exeTime = System.currentTimeMillis() - lastTime;
        System.out.println("original("+N+")   = " + result + " , exe times = " + times + " , exe time = " + exeTime);

        times = 0;
        lastTime = System.currentTimeMillis();
        result = optimize_1(N);
        exeTime = System.currentTimeMillis() - lastTime;
        System.out.println("optimize_1("+N+") = " + result + " , exe times = " + times + " , exe time = " + exeTime);

        times = 0;
        lastTime = System.currentTimeMillis();
        result = optimize_2(N);
        exeTime = System.currentTimeMillis() - lastTime;
        System.out.println("optimize_2("+N+") = " + result + " , exe times = " + times + " , exe time = " + exeTime);

        times = 0;
        lastTime = System.currentTimeMillis();
        result = optimize_3(N);
        exeTime = System.currentTimeMillis() - lastTime;
        System.out.println("optimize_3("+N+") = " + result + " , exe times = " + times + " , exe time = " + exeTime);

    }

    private static long original(int n) {
        times++;
        if (n>1)
            return original(n - 1) + original(n - 2);
        return n;
    }

    private static long optimize_1(int n) {
        times++;
        if (n>1) {
            long result = 1;
            do {
                result += optimize_1(n - 2);
                n--;
            } while (n > 1);
            return result;
        }
        return n;
    }

    private static long optimize_2(int n) {
        times++;
        if (n>1) {
            long a = 0, b = 1, temp;
            do {
                temp = b;
                b += a;
                a = temp;
            } while (--n > 1);
            return b;
        }
        return n;
    }

    private static long optimize_3(int n) {
        times++;
        if (n>1) {
            long a, b = 1;
            n--;
            a = n & 1;
            n /= 2;
            while (n-- > 0) {
                a += b;
                b += a;
            }
            return b;
        }
        return n;
    }
}
