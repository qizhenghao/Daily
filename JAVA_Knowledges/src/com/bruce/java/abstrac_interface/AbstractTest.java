package com.bruce.java.abstrac_interface;

/**
 * Created by qizhenghao on 16/11/25.
 */
public abstract class AbstractTest {
    public static final int i = 2;

    protected abstract void test();

    private AbstractTest(int i) {

    }

    protected AbstractTest(int i, int i1) {

    }

    //抽象类中可以有普通方法
    protected void haha(int i) {
        System.out.println(i);
    }
}
