package multithreading;

/**
 * Created by qijun123 on 2017/9/27.
 *
 *
 *
 *   一般而言，可能有三种原因引起阻塞：等待阻塞、同步阻塞以及其他阻塞
 *   （睡眠、jion或者IO阻塞，）；对于Java而言，等待阻塞是调用wait方法产生的，
 *   同步阻塞则是由同步块（synchronized）产生的，睡眠阻塞是由sleep产生的，
 *   jion阻塞是由jion方法产生的。
 *  一些不会抛出 InterruptedException 的线程阻塞操作（同步阻塞和io阻塞）
        然而，对于某些线程阻塞操作，JVM并不会自动抛出InterruptedException异常。
        例如，某些I/O操作和内部锁操作。对于这类操作，可以用其他方式模拟中断：
    1）java.io中的异步socket I/O
        读写socket的时候，InputStream和OutputStream的read和write方法会阻塞等待，
        但不会响应java中断。不过，调用Socket的close方法后，被阻塞线程会抛出SocketException异常。
    2）利用Selector实现的异步I/O
        如果线程被阻塞于Selector.select（在java.nio.channels中），调用wakeup方法会引起ClosedSelectorException异常。
    3）锁获取
        如果线程在等待获取一个内部锁，我们将无法中断它。但是，利用Lock类的lockInterruptibly方法，我们可以在等待锁的同时，提供中断能力。
 *
 *      如果线程被阻塞，比如wait,sleep,join 则用 thread.interrupt(); 产生异常
 *      如果是正常的代码，比如例子中的thread1，则通过判断标志位来结束程序
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"is running");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"is interrupting");
                e.printStackTrace();
            }
        });

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

        Thread thread1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"is running");
            long currentTime = System.currentTimeMillis();
            while (true && !Thread.currentThread().isInterrupted()){
                if(System.currentTimeMillis()-currentTime ==500L){
                    currentTime = System.currentTimeMillis();
                    System.out.println("running");
                }
            }
        });
        thread1.start();
        Thread.sleep(2000);
        thread1.interrupt();


    }
}
