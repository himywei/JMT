package state;

/**
 * @author wmy
 * @date 2021/8/2 22:59
 */
//观察测试线程状态
public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("////////////");
            }
        });

        //线程状态
        Thread.State state = thread.getState();
        System.out.println(state);

        //观察启动后
        thread.start();
        state = thread.getState();
        System.out.println(state);

        while (state != Thread.State.TERMINATED) { //只要线程不终止，一直输出状态
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }
        //测试停止之后能否再启动
        thread.start();
    }
}
