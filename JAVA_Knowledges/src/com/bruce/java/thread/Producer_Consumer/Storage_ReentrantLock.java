package com.bruce.java.thread.Producer_Consumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qizhenghao on 17/5/18.
 */
public class Storage_ReentrantLock extends AbstractStorage {

    List<Object> list = new LinkedList<Object>();

    private final Lock lock = new ReentrantLock();

    private final Condition full = lock.newCondition();

    private final Condition empty = lock.newCondition();

    @Override
    void produce(int num) {
        lock.lock();
        while (list.size() + num > MAX_SIZE) {
            System.out.println("【要生产的产品数量】:" + num + "/t【库存量】:"
                    + list.size() + "/t暂时不能执行生产任务!");
            try {
                full.await();//条件不足，生产阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Object());
        }

        System.out.println("【已经生产产品数】:" + num + "/t【现仓储量为】:" + list.size());
        full.signalAll();
        empty.signalAll();
        lock.unlock();
    }

    @Override
    void consume(int num) {
        lock.lock();
        while (list.size() < num) {
            System.out.println("【要消费的产品数量】:" + num + "/t【库存量】:"
                    + list.size() + "/t暂时不能执行生产任务!");
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.remove(list.size() - 1);
        }

        System.out.println("【已经消费产品数】:" + num + "/t【现仓储量为】:" + list.size());
        empty.signalAll();
        full.signalAll();
        lock.unlock();
    }
}
