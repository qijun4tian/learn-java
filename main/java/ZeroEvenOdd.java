import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author qijun
 * @date 2020/7/14 18:51
 *
 * 假设有这么一个类：
 *
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 *   public void zero(printNumber) { ... }  // 仅打印出 0
 *   public void even(printNumber) { ... }  // 仅打印出 偶数
 *   public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * 示例 1：
 *
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 *
 * 输入：n = 5
 * 输出："0102030405"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-zero-even-odd
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZeroEvenOdd {
    private int n;
    private Lock lock;
    private Condition zeroCondition;
    private Condition evenCondition;
    private Condition oddCondition;
    private volatile boolean evenFlag = false;
    private volatile boolean oddFlag = false;
    private volatile boolean zeroFlag = false;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        zeroCondition = lock.newCondition();
        evenCondition = lock.newCondition();
        oddCondition = lock.newCondition();

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i =1; i <= n; i++){
            try {
                boolean isEven = i % 2 == 0;
                lock.tryLock();
                printNumber.accept(i);
                if(isEven){
                    evenFlag = true;
                    evenCondition.signalAll();
                }else {
                    oddFlag = true;
                    oddCondition.signalAll();
                }
                zeroCondition.await();
            }finally {
                lock.unlock();
            }

        }
    }

    /*偶数*/
    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i= 2; i<=n; i += 2 ){
            try {
                lock.tryLock();
                while (!evenFlag){
                    evenCondition.await();
                }
                printNumber.accept(i);
                evenFlag = false;
                zeroCondition.signalAll();
            }finally {
                lock.unlock();
            }
        }

    }
    /*奇数*/
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i =1; i<=n; i += 2){
            try {
                lock.tryLock();
                while (!oddFlag){
                    oddCondition.await();
                }
                printNumber.accept(i);
                oddFlag = false;
                zeroCondition.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        IntConsumer intConsumer = System.out::print;
        new Thread(()-> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}).start();
        new Thread(()->{
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}