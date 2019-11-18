package com.codepig.establish.collable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 与Runnable相比，Callable可以有返回值，返回值通过FutureTask进行封装
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(myCallable);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}
