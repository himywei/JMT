package state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wmy
 * @date 2021/8/2 22:38
 */
//模拟倒计时
public class TestSlee2 {

    public static void turnDown() throws InterruptedException {
        int num = 10;
        while (true) {
            Thread.sleep(1000);
            System.out.println(num--);
            if (num <= 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        //打印当前系统时间
        Date startTime = new Date(System.currentTimeMillis());
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        try {
//            turnDown();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
