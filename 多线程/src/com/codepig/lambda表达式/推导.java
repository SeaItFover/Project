package com.codepig.lambda表达式;

import java.util.concurrent.Callable;

public class 推导 {

    public static void main(String[] args) {

        //外部类
        Thread tq = new Thread(new Person());
        tq.start();

        //内部类
        //方法内部类
        //lambda表达式
        Thread t5 = new Thread(() -> {
            for (int i = 0 ; i<3; i++){
                System.out.println(i);
            }
        });
    }
}

class Person extends Thread {
    @Override
    public void run() {
        System.out.println("外部类->run");
    }
}
