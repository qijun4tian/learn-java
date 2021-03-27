import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class H2O {

    private Lock lock;
    private Condition condition;
    private volatile int hCount = 0;
    private volatile int oCount = 0;

    public H2O() {
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try {
            while(hCount == 1) {
                condition.await();
            }
            releaseHydrogen.run();
            hCount++;
            if (oCount == 2 && hCount == 1) {
                hCount = 0;
                oCount = 0;
            }
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try {
            while(oCount == 2) {
                condition.await();
            }
            releaseOxygen.run();
            oCount++;
            if (oCount == 2 && hCount == 1) {
                hCount = 0;
                oCount = 0;
            }
            condition.signalAll();
        } finally {
            lock.unlock();
        }

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
    }
}
