package lambda;

/**
 * @author wmy
 * @date 2021/8/2 21:41
 */
public class TestLambda2 {
    public static void main(String[] args) {
        //lambda简化
        ILove love = (int a) -> {
            System.out.println("I LOVE " + a);
        };
        love.love(1);
        //简化1：参数类型简化、
        //多个参数也可以去掉参数类型
        ILove love2 = (a) -> {
            System.out.println("I LOVE " + a);
        };
        love2.love(2);
        //简化2：去掉（）
        ILove love3 = a -> {
            System.out.println("I LOVE " + a);
        };
        love3.love(3);
        //简化4：去掉花括号
        //lambda只能在只有一行代码的情况下去掉还括号（前提必须是函数式接口）
        ILove love4 = a -> System.out.println("I LOVE " + a);
        love4.love(4);
    }
}

interface ILove {
    void love(int a);
}

