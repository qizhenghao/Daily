package com.bruce.java.thread.Producer_Consumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by qizhenghao on 17/5/18.
 */
public abstract class AbstractStorage {

    protected int MAX_SIZE = 100;

    abstract void produce(int num);

    abstract void consume(int num);

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public void setMAX_SIZE(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }
}
