package com.codepig.establish.tothread;

public class Demo1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i<10000; i++){
            System.out.println("i ======================"+i);
        }
    }
}
