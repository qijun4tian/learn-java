package java.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("hello world");
        });


        for (int i = 0; i < 5; i++) {
            new Thread(new Thread1(i, cyclicBarrier)).start();
        }
    }

    static class Thread1 implements Runnable {

        private int id;
        private CyclicBarrier cyclicBarrier;

        public Thread1(int i, CyclicBarrier cyclicBarrier) {
            this.id = i;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("任务" + id + "已经结束运行");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
