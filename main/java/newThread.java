

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by qijun123 on 2017/5/8.
 */
public class newThread {

    public static void main(String[] args) {




        ExecutorService threadPool = Executors.newFixedThreadPool(5, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {

            }
        });


        for (int i = 0; i < 5; i++) {
            threadPool.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadsleep");
            });

        }
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(()-> System.out.println("goodbye"));



//        while (Thread.activeCount()>1)
//        {
//            System.out.println(Thread.activeCount());
//            Thread.yield();
//        }
        //判断线程池中是否有足够的线程
        threadPool.shutdown();
        while (true) {
            if (threadPool.isTerminated()) {
                System.out.println("结束了！");
                break;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.activeCount());

        Runnable runnable = ()-> System.out.println("1111111111");
        runnable.run();
    }

}
class testThread extends Thread{


    public void cancel()
    {
        interrupt();
    }
}
