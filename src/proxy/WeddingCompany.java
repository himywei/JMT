package proxy;

/**
 * @author wmy
 * @date 2021/8/2 18:39
 */
public class WeddingCompany implements Marry {
    private final Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }


    private void before() {
        System.out.println("结婚之前，布置现场！");
    }

    private void after() {
        System.out.println("结婚之后，收尾款！");

    }

}
