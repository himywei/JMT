package runnable;

import thread.TestThread2;
import utils.WebDownloader;

/**
 * @author wmy
 * @date 2021/8/2 10:43
 */
//实现多线程下载图片
public class TestRunnable2 implements Runnable {
    private final String url;
    private final String name;

    public TestRunnable2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downLoader(url, name);
        System.out.println("下载了：" + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://img1.baidu.com/it/u=3701370651,2867135978&fm=26&fmt=auto&gp=0.jpg", "pictures/t1.jpg");
        TestThread2 t2 = new TestThread2("https://img1.baidu.com/it/u=4041949070,2271085536&fm=11&fmt=auto&gp=0.jpg", "pictures/t2.jpg");
        TestThread2 t3 = new TestThread2("https://img0.baidu.com/it/u=1747155899,4222803875&fm=26&fmt=auto&gp=0.jpg", "pictures/t3.jpg");
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}


