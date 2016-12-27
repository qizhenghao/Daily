package com.bruce.java.abstrac_interface;

/**
 * Created by qizhenghao on 16/11/25.
 */
public interface InterfaceTest {
    int i = 1;//接口中变量默认是public stati final

    void test();

//    InterfaceTest();//接口不允许有构造方法

    //接口中的方法都必须是抽象的
//    void haha(int i) {
//        System.out.println(i);
//    }

    //接口中不支持静态方法
//    static void haha();
}
