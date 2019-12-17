package JUC.ProducerConsumerModel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 第一次写错了，错误点在于lock的用法错误，
 */
class Print01{
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try{
            while (num != 1){
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 5; i++){
                System.out.println("AA");
            }
            num = 2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try{
            while (num != 2){
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 10; i++){
                System.out.println("BB");
            }
            num = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try{
            while (num != 3){
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 15; i++){
                System.out.println("CC");
            }
            num = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}

public class Instance001 {
    public static void main(String[] args) {
        Print01 print = new Print01();
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                print.print5();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                print.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                print.print15();
            }
        },"C").start();
    }
}
