/**
 * Created by qijun123 on 2017/7/17.
 */
public class TestWhile {

    public static void main(String[] args) {

/*
        Runnable t1 = () -> {
            try {
                Thread.sleep(5000);
                System.out.println("1111");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(t1).start();
        long beginTime = System.currentTimeMillis();
        System.out.println(beginTime);
        while (true) {

            if (System.currentTimeMillis() - beginTime > 10000) {
                System.out.println("break");
                break;
            }
        }
        Runnable t2 = () -> {
            try {
                Thread.sleep(2000);
                System.out.println("2222");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        };
        new Thread(t2).start();
*/

          int a[] = {1,2,3};
        System.out.println(a[4]);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111111111");

            }
        });
    }
}
