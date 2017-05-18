package com.bruce.java.thread.Producer_Consumer;

/**
 * Created by qizhenghao on 17/5/18.
 */
public class Test {

    public static void main(String[] args) {
        AbstractStorage storage = new Storage_Synchronized();
        Producer producer1 = new Producer(storage, 3);
        Producer producer2 = new Producer(storage, 4);
        Producer producer3 = new Producer(storage, 5);

        Consumer consumer1 = new Consumer(storage, 3);
        Consumer consumer2 = new Consumer(storage, 4);

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
    }
}
