package state;

/**
 * @author wmy
 * @date 2021/8/3 8:56
 */
//测试线程优先级
public class TestPriority {
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority, "a");
        Thread t2 = new Thread(myPriority, "b");
        Thread t3 = new Thread(myPriority, "c");
        Thread t4 = new Thread(myPriority, "d");
        //先设置优先级，再启动
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

    }
}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getPriority());
    }
}
