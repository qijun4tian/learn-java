package java.multithreading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qijun123 on 2017/9/27.
 */
public class LockTest {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        final LockTest lockTest =new LockTest();
        new Thread(()->{lockTest.testLock(Thread.currentThread());}).start();
        new Thread(()->{lockTest.testLock(Thread.currentThread());}).start();
        new Thread(()->{lockTest.testTryLock(Thread.currentThread());}).start();
        new Thread(()->{lockTest.testTryLock(Thread.currentThread());}).start();

        System.out.println("开始测试LockInterrupt");
        Thread thread = new Thread(()->{
            try {
                lockTest.testLockInterrupt();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"被中断");
            }
        });
        thread.start();


    }
    public void testLock(Thread thread){
        lock.lock();
        try{
            thread.sleep(1000);
            System.out.println(thread.getName()+"获取了锁");
        }
        catch (Exception e){
// TODO: 2017/9/27
        }
        finally {
            lock.unlock();
        }
    }

    public void testTryLock(Thread thread){
        if(lock.tryLock()){
            try{
                System.out.println(thread.getName()+"获取了锁");

            }catch (Exception e){

            }
            finally {
                lock.unlock();
            }
        }
        else {
            System.out.println(thread.getName()+"没有获取锁");
        }
    }
 /*   lockInterruptibly 只能中断等待锁的线程
     1）如果当前线程未被中断，则获取锁。

     2）如果该锁没有被另一个线程保持，则获取该锁并立即返回，将锁的保持计数设置为 1。

     3）如果当前线程已经保持此锁，则将保持计数加 1，并且该方法立即返回。

      4）如果锁被另一个线程保持，则出于线程调度目的，禁用当前线程，并且在发生以下两种情况之一以
    前，该线程将一直处于休眠状态：
            1）锁由当前线程获得；或者

            2）其他某个线程中断当前线程。

      5）如果当前线程获得该锁，则将锁保持计数设置为 1。
    如果当前线程：
            1）在进入此方法时已经设置了该线程的中断状态；或者

             2）在等待获取锁的同时被中断。

    则抛出 InterruptedException，并且清除当前线程的已中断状态。


      6）在此实现中，因为此方法是一个显式中断点，所以要优先考虑响应中断，而不是响应锁的普通获取或

    重入获取。*/
    public void testLockInterrupt() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println(Thread.currentThread().getName()+"获取了锁");
            long startTime = System.currentTimeMillis();
            while(true){
                System.out.println(Thread.currentThread().getName()+"正在工作");
                if(System.currentTimeMillis()-startTime>=30000l)
                {
                    break;
                }
            }
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+"被中断释放锁");
        }
    }


}
