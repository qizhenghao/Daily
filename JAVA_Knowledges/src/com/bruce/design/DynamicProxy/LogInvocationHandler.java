package com.bruce.design.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by qizhenghao on 17/4/11.
 */
public class LogInvocationHandler implements InvocationHandler{

    private Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是 " + method.getName() + " 方法执行前的log");
        System.out.println(proxy.getClass().getName());
        method.invoke(target, args);
        System.out.println("我是 " + method.getName() + " 方法执行前的log");
        return null;
    }
}
