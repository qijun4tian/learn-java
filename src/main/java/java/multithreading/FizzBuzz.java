package java.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author qijun
 * @date 2020/7/22 16:28
 */
public class FizzBuzz {
    private volatile int n;
    private volatile int i;


    private Lock lock;
    private Condition condition;
    public FizzBuzz(int n) {
        this.n = n;
        this.i = 1;
        this.lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    // printFizz.run() outputs "fizz". 3
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (n >= 0) {
            lock.lock();
            try {
                while (i % 3 != 0 || i % 5 == 0) {
                    if (n <= 0) {
                        break;
                    }
                    condition.await();
                }
                n--;
                i++;
                printFizz.run();
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz". 5
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (n >= 0){
            lock.lock();
            try{
                while (i % 5 != 0 || i % 3 == 0){
                    if(n <= 0) {
                        break;
                    }
                    condition.await();
                }
                n--;
                i++;
                printBuzz.run();
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }
    // printFizzBuzz.run() outputs "fizzbuzz". 3*5
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (n>= 0) {
            lock.lock();
            try {
                while (i % 3 != 0 || i % 5 != 0) {
                    if(n <= 0){
                        break;
                    }
                    condition.await();
                }
                printFizzBuzz.run();
                n--;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer. 不能被3 5整除
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (n >= 0) {
            lock.lock();
            try {
                while (i % 3 == 0 || i % 5 == 0) {
                    if(n <= 0){
                        break;
                    }
                    condition.await();
                }
                printNumber.accept(i);
                i++;
                n--;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
