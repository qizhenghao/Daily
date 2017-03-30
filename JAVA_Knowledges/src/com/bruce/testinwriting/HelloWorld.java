package com.bruce.testinwriting;

import java.util.Set;

/**
 * Created by qizhenghao on 17/3/18.
 */
public class HelloWorld {

    private static int count(int[] array, int i, int j) {

        // 如果array中有重复的数字，返回1，否则返回0

        return 0;

    }

    public static int countX(int [] array) {

        int dp[] = new int[array.length];

        dp[0] = 0;

        for(int i = 1; i < dp.length; i++) {

            for( int k = 0; k < i; k++) {

                dp[i] = dp[i - 1] * count(array, k, i);

            }

        }

        return dp[array.length - 1];

    }



}
