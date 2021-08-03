package lambda;

/**
 * @author wmy
 * @date 2021/8/2 21:29
 */
public class TestLambda {
    //静态内部类
    static class Like2 implements ILike {

        @Override
        public void lambda() {
            System.out.println(" i like lambda2");
        }
    }


    public static void main(String[] args) {
        ILike iLike = new Like();
        iLike.lambda();

        iLike = new Like2();
        iLike.lambda();

        //局部内部类
        class Like3 implements ILike {

            @Override
            public void lambda() {
                System.out.println(" i like lambda3");
            }
        }
        iLike = new Like3();
        iLike.lambda();

        //匿名内部类
        iLike = new ILike() {

            @Override
            public void lambda() {
                System.out.println(" i like lambda4");
            }
        };
        iLike.lambda();

        //lambda简化
        iLike = () -> {
            System.out.println(" i like lambda5");
        };
        iLike.lambda();
    }
}

