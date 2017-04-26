package com.bruce.java.thread;

/**
 * Created by qizhenghao on 17/4/26.
 */
public class TestDeadLock implements Runnable{

    int flag = 0;
    static Object o1 = new Object(), o2 = new Object();

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);

//        TestDeadLock deadLock1 = new TestDeadLock();
//        TestDeadLock deadLock2 = new TestDeadLock();
//        deadLock1.flag = 0;
//        deadLock1.flag = 1;
//        Thread thread1 = new Thread(deadLock1);
//        Thread thread2 = new Thread(deadLock2);
//        thread1.start();
//        thread2.start();

    }

    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if (flag == 0) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {

                }
            }
        } else if (flag == 1) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {

                }
            }
        }
    }
}
