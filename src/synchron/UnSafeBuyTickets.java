package synchron;

import state.TestJoin;

/**
 * @author wmy
 * @date 2021/8/3 9:18
 */
//不安全买票
public class UnSafeBuyTickets {
    public static void main(String[] args) {
        BuyTickets buyTickets = new BuyTickets();
        new Thread(buyTickets, "a").start();
        new Thread(buyTickets, "b").start();
        new Thread(buyTickets, "c").start();
    }
}

class BuyTickets implements Runnable {
    //票
    private int ticketNums = 10;
    //线程外部停止方式
    boolean flag = true;

    @Override
    public void run() {
        //买票
        while (flag) {
            buy();
        }
    }

    //synchronized同步方法,锁的是this
    private synchronized void buy() {
        //判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票
        System.out.println(Thread.currentThread().getName() + "买到" + ticketNums--);
    }
}
