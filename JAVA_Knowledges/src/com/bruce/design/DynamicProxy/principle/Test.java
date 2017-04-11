package com.bruce.design.DynamicProxy.principle;


public class Test {
    public static void main(String[] args) throws Exception {
        Tank tank = new Tank();
        InvocationHandler handler = new TimeHandler(tank);

        //自己写的,我没有传进去classloader，接口也只是象征性的写了一个

        IShoot iShoot = (IShoot) Proxy.newProxyInstance(Tank.class.getInterfaces(), handler);

        iShoot.shoot();
    }
}
//可以对任意的对象、任意的接口方法，实现任意的代理