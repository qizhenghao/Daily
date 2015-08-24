package com.bruce.design.singleton;

/**
 * Created by qizhenghao on 15-8-24.
 *
 * 单例模式
 *
 * 双重锁定(Double-Check Locking)
 */
public class Singleton {

    private static Singleton singleton = null;

    private Singleton(){}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
