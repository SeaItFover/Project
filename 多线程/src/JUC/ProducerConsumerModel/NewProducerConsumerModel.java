package JUC.ProducerConsumerModel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 新的生产者消费者模式是采用lock、await、signal
 *
 */
class Cake02{
    private int nums = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //判断/干活/通知
    public void produceCake(){
        lock.lock();

        try{
            while (nums != 0){
                condition.await();
            }
            nums++;
            System.out.println(Thread.currentThread().getName()+"\t"+nums);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void consumeCake(){
        lock.lock();

        try{
            while (nums == 0){
                condition.await();
            }
            nums--;
            System.out.println(Thread.currentThread().getName()+"\t"+nums);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
             lock.unlock();
        }
    }
}
public class NewProducerConsumerModel {
    public static void main(String[] args) {
        Cake02 cake = new Cake02();
        new Thread(()->{
            for (int i = 0; i < 20; i++){
                cake.produceCake();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++){
                cake.consumeCake();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++){
                cake.produceCake();
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++){
                cake.consumeCake();
            }
        },"D").start();
    }
}
