package com.codepig.establish.tothread;

public class Test {

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Demo2 demo2 = new Demo2();

        //直接执行run方法
        demo1.run();
        demo2.run();  //结果是依照顺序执行，并未开启多线程

        //调用start方法（由于两个demo都是直接继承自Thread类，所以可以直接调用）
        demo1.start();
    }
}
