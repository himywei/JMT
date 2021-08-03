package synchron;

/**
 * @author wmy
 * @date 2021/8/3 9:27
 */
//不安全取钱
public class UnSafeBank {
    public static void main(String[] args) {
        //创建账户
        Account account = new Account("银行卡", 1000);
        Drawing you = new Drawing(account, 50, "你");
        Drawing her = new Drawing(account, 100, "她");
        you.start();
        her.start();

    }
}

class Account {
    String name;
    int money;

    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }
}

//模拟银行取款
class Drawing extends Thread {
    Account account; //账户
    //取了多少钱
    int drwaingMoney;
    //现在手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drwaingMoney, String name) {
        super(name);
        this.account = account;
        this.drwaingMoney = drwaingMoney;
    }

    //synchronized锁的是this
    @Override
    public void run() {
        //锁的对象是变化的量
        synchronized (account) {
            System.out.println(this.getName() + "想取：" + drwaingMoney);

            //判断有没有钱
            if (account.money - drwaingMoney < 0) {
                System.out.println("余额不足...");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额
            account.money -= drwaingMoney;
            //你手里的钱
            nowMoney = nowMoney + drwaingMoney;
            System.out.println(account.name + "的余额是： " + account.money);
            System.out.println(this.getName() + "手里的钱是：" + nowMoney);
        }

    }
}
