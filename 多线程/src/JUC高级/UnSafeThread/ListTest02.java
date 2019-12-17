package JUC高级.UnSafeThread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 发生java.util.ConcurrentModificationException时（并发修改异常）
 * 原因：
 * 解决方法：
 * 1.使用new Vector();vector是线程安全的，但是不推荐使用
 * 2.使用Collections.SynchronizedList()将线程不安全的集合转化为线程安全的。
 * 3.使用JUC包下的CopyOnWriteArrayList类。
 *
 * 关键是到底是因为读写之间不同步执行的问题，还是只是写的时候出错了
 * 异常到底是因为什么
 *
 * 线程体
 *
 *
 * 几个人同时签到表，一个人拿上copy签到表走了，他拿着笔（锁），在写的过程中，其他人(这些其他人一定是已经写过的人，那些还没写过
 * 的人只能等着，既不能写，也不能读）在读原先的那张，等他写完了，释放笔也即锁，另一个
 * 人拿着锁copy了一份再写，其他人读第一个人写完的表
 *
 * 由于代码顺序执行，所以对于同一个线程，一定是先写后读。
 */
public class ListTest02 {
    public static void main(String[] args) throws InterruptedException {
        List list = //new LinkedList();//new ArrayList()
        new CopyOnWriteArrayList<>();
        for (int i = 0; i<30; i++){
            final int j = i;
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                //list.add(j);
                System.out.println(list+Thread.currentThread().getName());
            },String.valueOf(i)).start();
        }
//        list.add(UUID.randomUUID().toString().substring(0,8));
//        System.out.println(list);
        Thread.sleep(2000);
        System.out.println(list+String.valueOf(list.size()));
    }
}
