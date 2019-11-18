package com.codepig.cooperation;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 协作模型：生产者消费者实现方式一：管程法
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

//生产者（多线程）
class Producer extends Thread{
    SynContainer container;

    public Producer(SynContainer container){
        super();
        this.container = container;
    }

    @Override
    public void run() {
        //生产
        for (int i = 0;i<100;i++){
            System.out.println("生产第"+i+"个馒头");
            container.push(new Steamedbun(i));
        }

    }
}
//消费者（多线程）
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {

        //消费
        for (int i = 0; i<1000; i++){
            System.out.println("消费第"+container.pop().id+"个馒头");
        }

    }
}
//缓冲区
class SynContainer{
    Steamedbun[] buns = new Steamedbun[20];  //存储容器
    int count = 0; //计数器
    //存储 生产
    public synchronized void push(Steamedbun bun){
        //何时能生产  容器存在空间

        //不能生产
        if (count == buns.length){
            try {
                this.wait();  //线程阻塞，消费者通知生产，则消费解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在空间  可以生产
        buns[count] = bun;
        count++;
        //存在数据了，可以通知消费了
        this.notifyAll();
    }
    //获取
    public synchronized Steamedbun pop(){
        //何时能消费：容器中是否存在数据
        //没有数据 只有等待
        if (count == 0){
            try {
                this.wait();  //线程阻塞 生产者通知消费解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在数据可以消费
        count--;
        this.notifyAll();  //存在空间了，可以唤醒对方生产了
        return buns[count];
    }
}
//馒头（数据）
class Steamedbun{
    int id;

    public Steamedbun(int id){
        this.id = id;
    }

}