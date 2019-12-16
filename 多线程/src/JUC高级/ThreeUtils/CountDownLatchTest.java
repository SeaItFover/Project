package JUC高级.ThreeUtils;

import java.util.concurrent.CountDownLatch;

/**
 * 一个线程计数器，调用await的线程就等待
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0 ;i<5; i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("班长离开了教室");
    }
}
