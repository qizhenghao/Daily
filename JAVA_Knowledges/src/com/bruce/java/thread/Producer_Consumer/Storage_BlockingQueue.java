package com.bruce.java.thread.Producer_Consumer;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by qizhenghao on 17/5/18.
 */
public class Storage_BlockingQueue extends AbstractStorage {

    private LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(MAX_SIZE);

    @Override
    void produce(int num) {
        if (linkedBlockingQueue.size() == MAX_SIZE) {
            System.out.println("【库存量】:" + MAX_SIZE + "/t暂时不能执行生产任务!");
        }
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(30);
                linkedBlockingQueue.put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("【现仓储量为】:" + linkedBlockingQueue.size());
        }
    }

    @Override
    void consume(int num) {
        if (linkedBlockingQueue.size() == 0) {
            System.out.println("【库存量】:0/t暂时不能执行生产任务!");
        }
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(30);
                linkedBlockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
