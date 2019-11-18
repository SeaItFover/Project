package com.codepig.establish.tothread;

/**
 * 要明白开启线程的时机，如果main方法中的程序在其他线程开启之前，那么是先执行完程序后开辟线程。
 */
public class Test2 {
    public static void main(String[] args) {
        for (int k = 0 ;k <100; k++){
            System.out.println("k="+k);
        }

        Demo1 demo1 = new Demo1();
        demo1.start();


    }
}
