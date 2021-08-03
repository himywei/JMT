package state;

import runnable.TestRunnable3;

/**
 * @author wmy
 * @date 2021/8/2 22:38
 */
//模拟网络延时
public class TestSleep implements Runnable {

    //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums < 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 拿到了第 " + ticketNums-- + " 张票...");
        }
    }

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();
        new Thread(testSleep, "A").start();
        new Thread(testSleep, "B").start();
        new Thread(testSleep, "C").start();
    }
}
