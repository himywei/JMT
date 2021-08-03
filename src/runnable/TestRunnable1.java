package runnable;

/**
 * @author wmy
 * @date 2021/8/2 11:00
 */
//创建线程方式2：实现Runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
public class TestRunnable1 implements Runnable {


    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 1000; i++) {

            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        TestRunnable1 testRunnable1 = new TestRunnable1();
        //创建线程对象，通过线程对象开启线程，代理
        Thread thread = new Thread(testRunnable1);
        //调用start开启线程
        thread.start();
        for (int i = 0; i < 1000; i++) {

            System.out.println("我在学习多线程" + i);
        }
    }
}
