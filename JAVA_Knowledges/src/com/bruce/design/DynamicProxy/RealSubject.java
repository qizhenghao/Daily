package com.bruce.design.DynamicProxy;

/**
 * Created by qizhenghao on 17/4/11.
 */
public class RealSubject implements OnClickListener {
    @Override
    public void onClick() {
        System.out.println("RealSubject");
    }
}
