package JUC高级.ThreeUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 与CountDownLatch不同的是，这个工具类是逐渐增加，等到增加到一个值，再执行指定线程
 */
public class CyclicBarrierTest{
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });
        for (int i=0; i<7; i++){
            final int j = i;
            new Thread(()->{
                System.out.println("找到了第"+j+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"A").start();
        }
    }
}
