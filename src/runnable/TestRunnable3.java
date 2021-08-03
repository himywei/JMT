package runnable;

/**
 * @author wmy
 * @date 2021/8/2 10:43
 */
//多个线程同时操作同一个对象。例子：买火车票
//多个线程操作同一个资源的情况下，资源被重复使用
public class TestRunnable3 implements Runnable {

    //票数
    private int ticketNums = 100;

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
        TestRunnable3 testRunnable3 = new TestRunnable3();
        new Thread(testRunnable3, "A").start();
        new Thread(testRunnable3, "B").start();
        new Thread(testRunnable3, "C").start();
    }
}


