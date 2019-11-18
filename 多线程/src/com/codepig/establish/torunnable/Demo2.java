package com.codepig.establish.torunnable;

public class Demo2 implements Runnable {
    @Override
    public void run() {
        for (int j = 1; j<100 ;j++){
            System.out.println("j = " +j);
        }
    }
}
