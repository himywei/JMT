package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wmy
 * @date 2021/8/3 10:24
 */
//测试lock锁
public class TestLock {
    public static void main(String[] args) {
        TestLoc2 testLoc2 = new TestLoc2();
        new Thread(testLoc2).start();
        new Thread(testLoc2).start();
        new Thread(testLoc2).start();
    }
}

class TestLoc2 implements Runnable {

    int ticketNums = 10;
    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock(); //加锁
                if (ticketNums > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                } else {
                    break;
                }
            } finally {
                //解锁
                lock.unlock();
            }

        }

    }
}
