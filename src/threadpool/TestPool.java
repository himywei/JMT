package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wmy
 * @date 2021/8/3 11:13
 */
//测试线程池
public class TestPool {
    public static void main(String[] args) {
        //1.创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //执行
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        //2.关闭连接
        executorService.shutdownNow();
    }

}

class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}