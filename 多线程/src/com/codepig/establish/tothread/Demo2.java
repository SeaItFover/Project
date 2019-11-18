package com.codepig.establish.tothread;

public class Demo2 extends Thread {
    @Override
    public void run() {
        for (int j = 1; j<10000; j++){
            System.out.println("j===="+j);
        }
    }
}
