package com.codepig.establish.torunnable;

public class Demo1 extends Object implements Runnable {
    @Override
    public void run() {
        for (int i =1 ; i<100; i++){
            if ( i == 10){
                Thread.yield();
            }else{
                System.out.println("i = " +i );
            }

        }
    }
}
