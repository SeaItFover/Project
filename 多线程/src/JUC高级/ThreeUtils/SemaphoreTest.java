package JUC高级.ThreeUtils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 以前学的多线程我们是多个线程争夺一个资源，现在是多个线程争夺多个资源
 * 但是资源有限，也就类似锁的数量固定，同一时间只有这个数量的线程可以进入
 * 之前的多线程只有一个锁，同一时间只有一个线程可以进入。
 *
 * 信号灯工具类
 * 下面主要有两个方法
 * 一个是获取acquire
 * 一个是释放release
 * 也就是只有当某个线程用完资源类的时候，才会释放
 *
 *
 * 线程体、资源类、类中的方法
 */
class Test{
    Semaphore s = new Semaphore(3);
    public void get(){
        try{
            s.acquire();
            System.out.println(Thread.currentThread().getName()+"获得了车位");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName()+"离开车位");
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            s.release();
        }
    }
}
public class SemaphoreTest {
    public static void main(String[] args) {
        Test t = new Test();
        new Thread(()->{
            t.get();
        },"a").start();
        new Thread(()->{
            t.get();
        },"b").start();
        new Thread(()->{
            t.get();
        },"c").start();
        new Thread(()->{
            t.get();
        },"d").start();
        new Thread(()->{
            t.get();
        },"e").start();new Thread(()->{
            t.get();
        },"f").start();new Thread(()->{
            t.get();
        },"g").start();
//        for (int i=1; i<6;i++){
//            new Thread(()->{
//                t.get();
//            },String.valueOf(i)).start();
//    }
    }
}
