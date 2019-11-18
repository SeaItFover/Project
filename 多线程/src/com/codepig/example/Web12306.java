package com.codepig.example;

public class Web12306 implements Runnable {
    private int tickerNums = 99;
    @Override
    public void run() {
        while (tickerNums>0){
            System.out.println(Thread.currentThread().getName()+"-->"+tickerNums--);
        }

    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        new Thread(web,"1").start();
        new Thread(web,"2").start();
        new Thread(web,"3").start();

    }
}
