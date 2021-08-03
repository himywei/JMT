package lock;

/**
 * @author wmy
 * @date 2021/8/3 10:11
 */
//死锁测试
public class DeadLock {
    public static void main(String[] args) {
        Makeup m1 = new Makeup(0, "灰姑娘");
        Makeup m2 = new Makeup(1, "白雪公主");
        m1.start();
        m2.start();

    }
}

//口红
class Lipstick {

}

//化妆
class Mirror {

}

class Makeup extends Thread {

    //需要的资源只有一份，用static保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;//使用化妆品的人

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        //化妆
        makeup();

    }

    private void makeup() {
        if (choice == 0) {
            synchronized (lipstick) { //获得口红的锁
                System.out.println(this.girlName + "获得口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (mirror) { //一秒钟后获得镜子的锁
                System.out.println(this.girlName + "一秒钟后获得镜子的锁");
            }
        } else {
            synchronized (mirror) { //获得镜子的锁
                System.out.println(this.girlName + "获得镜子的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (lipstick) { //一秒钟后获得口红的锁
                System.out.println(this.girlName + "一秒钟后获得口红的锁");
            }
        }
    }
}
