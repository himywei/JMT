package proxy;

/**
 * @author wmy
 * @date 2021/8/2 18:37
 */
//静态代理模式总结:
//真实对象和代理对象都要实现同一个接口
// 代理对象代理真实角色
//优点:代理对象可以做很多真实对象做不了的事情，真实对象专注做自己的事情
public class StaticProxy {
    public static void main(String[] args) {

//        You you = new You();
//        WeddingCompany weddingCompany = new WeddingCompany(you);
//        weddingCompany.happyMarry();
        new WeddingCompany(new You()).happyMarry();
        new Thread(() -> System.out.println(" I LOVE YOU")).start();


    }
}
