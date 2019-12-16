package JUC高级.example;

/**
 * 线程   操作  资源类
 * 二话不说，先建立一个资源类
 *
 */
class Ticket{
    private int ticketNums = 300;

    public synchronized void saleTicket(){
        if (ticketNums > 0){
            System.out.println(Thread.currentThread().getName()+"买了第"+ticketNums--+"剩下"+ticketNums);
        }
    }
}
public class SaleTicket {
    public static void main(String[] args) {
        //缺少资源，我们直接new一个资源
        Ticket ticket = new Ticket();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ;i <400; i++){
                    ticket.saleTicket();
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ;i <400; i++){
                    ticket.saleTicket();
                }
            }
        },"B").start();
    }
}
