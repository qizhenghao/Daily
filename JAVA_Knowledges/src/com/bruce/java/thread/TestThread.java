package com.bruce.java.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by qizhenghao on 16/12/29.
 */
public class TestThread {

    public static void main(String[] args) {

        final MyThread myThread = new MyThread();
        myThread.start();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                myThread.shutDown();
                try {
                    myThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 3500);
    }

    public static class MyThread extends Thread {

        private volatile boolean stop = false;
        @Override
        public void run() {
            try {
                while (!stop) {
                    Thread.sleep(1000);
                    doWork();
                }
            } catch (InterruptedException e) {
            } finally {
                System.out.println("finally...");
            }
        }

        public final void shutDown() {
            System.out.println("shutDown...");
            stop = true;
            interrupt();
        }

        private void doWork() {
            System.out.println("doWork...");
        }
    }

}
