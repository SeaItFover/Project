package com.codepig.example;

/**
 * 线程操作资源类
 * 线程：Thread t1 = new Thread(racer,"rabbit");
 * 操作：放在了资源类中，由资源类实现Runnable接口的run方法。
 * 资源类：Racer
 */
public class Racer implements Runnable {
    private static String winner;
    @Override
    public void run() {
        for (int steps = 1; steps <=100; steps++){
            System.out.println(Thread.currentThread().getName()+"-->"+steps);
            if (gameOver(steps)){
                break;
            }
        }

    }

    public static boolean gameOver(int steps) {
        if (winner != null){
            return true;
        }else{
            if (steps == 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner==>"+winner);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        Thread t1 = new Thread(racer,"rabbit");
        Thread t2 = new Thread(racer,"tortoise");
        t1.start();
        t2.start();
    }
}
