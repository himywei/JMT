package state;

/**
 * @author wmy
 * @date 2021/8/3 9:05
 */
//测试守护线程
//虚拟机不用等待守护线程执行完毕
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread thread = new Thread(god);
        thread.setDaemon(true); //设置该线程为守护线程
        thread.start();//守护线程启动

        new Thread(you).start(); //用户线程启动
    }

}

class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑你...");
        }
    }
}

class You implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都很开心。。。");
        }
        System.out.println("再见，世界！");
    }
}
