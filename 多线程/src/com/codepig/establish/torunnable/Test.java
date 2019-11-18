package com.codepig.establish.torunnable;

public class Test {
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Demo2 demo2 = new Demo2();

        Thread t1 = new Thread(demo1);
        Thread t2 = new Thread(demo2);

        t1.start();
        t2.start();
    }
}
