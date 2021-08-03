package callable;

import thread.TestThread2;
import utils.WebDownloader;

import java.util.concurrent.*;

/**
 * @author wmy
 * @date 2021/8/2 10:43
 */
//多个线程同时操作同一个对象。例子：买火车票
//callable可以定义返回值，可以抛出异常

public class TestCallable implements Callable<Boolean> {

    private final String url;
    private final String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }


    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downLoader(url, name);
        System.out.println("下载了：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable c1 = new TestCallable("https://img1.baidu.com/it/u=3701370651,2867135978&fm=26&fmt=auto&gp=0.jpg", "pictures/t1.jpg");
        TestCallable c2 = new TestCallable("https://img1.baidu.com/it/u=4041949070,2271085536&fm=11&fmt=auto&gp=0.jpg", "pictures/t2.jpg");
        TestCallable c3 = new TestCallable("https://img0.baidu.com/it/u=1747155899,4222803875&fm=26&fmt=auto&gp=0.jpg", "pictures/t3.jpg");
        //创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = executorService.submit(c1);
        Future<Boolean> r2 = executorService.submit(c2);
        Future<Boolean> r3 = executorService.submit(c3);
        //获取结果
        boolean b1 = r1.get();
        boolean b2 = r2.get();
        boolean b3 = r3.get();
        //关闭服务
        executorService.shutdownNow();

    }
}


