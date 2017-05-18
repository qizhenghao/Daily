package com.bruce.java;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by qizhenghao on 15-12-4.
 */
public class AboutString {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(",a,,,,,".split(",")));
        System.out.println(Arrays.toString(",,a,".split(",")));


        String A = "a我我我";
        String B = "a我我我";
        String C = A;
        String D = new String("a我我我");
        String F = "a" + "我我我";

        System.out.println("b" == "b");
        System.out.println( A == B);
        System.out.println( A == "a我我我");
        System.out.println( A == C);
        System.out.println( A == D);
        System.out.println( A == F);

        User userA = new User();
    }

    static class User{
        String name;
    }
}
