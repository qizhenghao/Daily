package com.bruce.java.thread;

public class PrintOneTwoThree {
    public static void main(String[] args) {
        Print p1 = new Print(0);
        Print p2 = new Print(1);
        Print p3 = new Print(2);
 
        new Thread(p1, "p1").start();
        new Thread(p2, "p2").start();
        new Thread(p3, "p3").start();
 
        while (Thread.activeCount() > 1)
            ;
        System.out.println("Done!");
    }
}

class Print implements Runnable {
    private static int state = 0;
    private int id;
    private static Object lock = new Object();

    public Print(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (state < 30) {
                if (state % 3 == id) {
                    switch (id) {
                    case 0:
                        System.out.println("["
                                + Thread.currentThread().getName() + "]" + "A " + state);
                        break;

                    case 1:
                        System.out.println("["
                                + Thread.currentThread().getName() + "]" + "B " + state);
                        break;

                    case 2:
                        System.out.println("["
                                + Thread.currentThread().getName() + "]" + "C " + state);
                        break;

                    default:
                        break;
                    }
                    state++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}