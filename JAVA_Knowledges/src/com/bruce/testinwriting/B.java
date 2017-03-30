package com.bruce.testinwriting;

public class B {
    int a;

    static int b = 1;

    static final int c;

    static {
        b = 2;
        c = 3;
        System.out.println("Base: static");
    }

    B(int x) {
        setup(x);
    }

    public void setup(int x) {
        this.a = x;
    }

    public void display() {
        System.out.println("a = " + a + ", " + "b = " + b + ", c = " + c);
    }
}

class A extends B {
    int f;

    static int e = 1;

    static int d = 4;

    static {
        e = 4;
        d = 5;
        System.out.println("A: static");
    }

    A(int x) {
        super(x);
    }

    public void setup(int x) {
        this.f = x;
    }

    public void display() {
        super.display();
        System.out.println("f = " + f + ", " + "e = " + e + ", d = " + d);
    }

    public static void main(String[] args) {
        new A(100).display();
    }
}
