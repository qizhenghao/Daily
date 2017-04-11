package com.bruce.design.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by qizhenghao on 17/4/11.
 */
public class Test  {

    public static void main(String[] args) {

        OnClickListener subject = new RealSubject();
        InvocationHandler invocationHandler = new LogInvocationHandler(subject);
        OnClickListener onClickListener = (OnClickListener) Proxy.newProxyInstance(OnClickListener.class.getClassLoader(), RealSubject.class.getInterfaces(), invocationHandler);
        onClickListener.onClick();
    }
}
