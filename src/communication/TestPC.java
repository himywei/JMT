package communication;

/**
 * @author wmy
 * @date 2021/8/3 10:40
 */
//管程法模拟线程通信
public class TestPC {
    public static void main(String[] args) {
        Syncontainer syncontainer = new Syncontainer();
        new Productor(syncontainer).start();
        new Customer(syncontainer).start();
    }
}

//生产者
class Productor extends Thread {
    Syncontainer syncontainer;

    public Productor(Syncontainer syncontainer) {
        this.syncontainer = syncontainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了" + i + "只鸡");
            syncontainer.push(new Chicken(i));
        }
    }
}

//消费者
class Customer extends Thread {
    Syncontainer syncontainer;

    public Customer(Syncontainer syncontainer) {
        this.syncontainer = syncontainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了" + syncontainer.pop().id + "只鸡");
            ;
        }
    }
}

//产品
class Chicken {
    int id;

    public Chicken(int num) {
        this.id = num;
    }
}

//缓冲区
class Syncontainer {
    //容器
    Chicken[] chickens = new Chicken[10];
    //容器计数器
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken) {
        //如果容器满了，需要等待消费者消费
        if (count == chickens.length) {
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没满，需要放入产品
        chickens[count] = chicken;
        count++;
        //通知消费者消费
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken pop() {
        //判断能否消费
        if (count == 0) {
            //等待生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        //如果可以消费
        count--;
        Chicken chicken = chickens[count];

        //吃完了，等待生产者生产
        this.notifyAll();
        return chicken;
    }
}

