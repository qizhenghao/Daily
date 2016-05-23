package com.bruce.java.math;

import java.util.Random;

/**
 * Created by qizhenghao on 15-9-8.
 */
public class TestRandom {

    public static void main(String[] args) {

        int[] ids = new int[]{0,1,2,3,4};

        int randomId = ids[(new Random()).nextInt(ids.length)];//产生随机图片id

        System.out.println(randomId);

        int n = -10;
        System.out.println(n%100);
    }
}
