package synchron;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmy
 * @date 2021/8/3 9:48
 */
//线程不安全集合
public class UnSafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}
