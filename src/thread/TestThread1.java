package thread;

/**
 * @author wmy
 * @date 2021/8/2 10:24
 */
//创建线程方式1：继承Thread类，重写run方法，调用start开启线程
public class TestThread1 extends Thread {


    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 1000; i++) {

            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {
        //main主线程

        //创建一个线程对象
        TestThread1 testThread1 = new TestThread1();
        //调用start开启线程
        testThread1.start();

        for (int i = 0; i < 1000; i++) {

            System.out.println("我在学习多线程" + i);
        }
    }
}
