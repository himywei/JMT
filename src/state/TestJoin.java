package state;

/**
 * @author wmy
 * @date 2021/8/2 22:53
 */
//测试join方法（插队）
public class TestJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程 VIP 执行" + i);
        }
    }

    public static void main(String[] args) {
        //启动我们的线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        //主线程
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                try {
                    thread.join();//线程插队
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main 线程执行" + i);
        }
    }
}
