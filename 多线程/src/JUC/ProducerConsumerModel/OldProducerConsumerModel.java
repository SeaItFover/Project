package JUC.ProducerConsumerModel;

import sun.security.krb5.internal.crypto.CksumType;

/**
 * 旧的生产者消费者模式采用synchronized关键字以及wait、notify这一套
 * 首先：线程操作资源类
 * 所有操作按照高内聚低耦合的原则集成在资源类中
 * 操作步骤：判断/干活/通知
 */
//资源类
class Cake{
    private int nums = 1;
    //操作：生产蛋糕
    public synchronized void produceCake(){
        while (nums != 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nums++;
        System.out.println(Thread.currentThread().getName()+"\t"+nums);
        this.notifyAll();
    }
    //操作：消费蛋糕
    public synchronized void consumeCake(){
        while (nums == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nums--;
        System.out.println(Thread.currentThread().getName()+"\t"+nums);
        this.notifyAll();
    }
}
public class OldProducerConsumerModel {
    public static void main(String[] args) {
        //new一个资源类
        Cake cake = new Cake();
        //线程
        new Thread(()->{
            for (int i = 0; i < 30; i++){
                cake.produceCake();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i <30; i++){
                cake.consumeCake();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i <30 ; i++){
                cake.produceCake();
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 30; i++){
                cake.consumeCake();
            }
        },"D").start();
    }
}
