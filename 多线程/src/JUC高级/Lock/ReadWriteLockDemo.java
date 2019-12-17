package JUC高级.Lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 本来就有锁，为什么要重新弄一个读写锁，原因是什么
 * 原先的锁是将读和写都锁住了，但是读的时候不该锁，可以有多个线程同时对资源进行读取
 *
 * 读读可以共存
 * 读写不可以共存
 * 写写不可以共存
 *
 */
class MyCache{
    private volatile Map map = new HashMap(); //16   0.75
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, String value){
        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"写入数据"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入完成");
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }
    public void get(String key){
        readWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"读取数据");
            Object value = map.get(key);
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println(Thread.currentThread().getName()+"读取完成"+value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            readWriteLock.readLock().unlock();
        }
    }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 6; i++){
            final int tempInt = i;
            new Thread(()->{
                myCache.put(tempInt+"",tempInt+"");
            }).start();
        }
        for (int i = 0; i < 6; i++){
            final int tempInt = i;
            new Thread(()->{
                myCache.get(tempInt+"");
            }).start();
        }
    }
}
