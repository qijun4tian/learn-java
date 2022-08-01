package java.队列和广度搜索;

/**
 * @Author:qijun
 * @Description
 * @Date 17:07 2022/1/3
 */
public class MyCircularQueue {

    private final int[] a;
    private int head;
    private int tail;

    private final int size;

    public MyCircularQueue(int k) {
        a = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    public boolean enQueue(int value) {
        if (isEmpty()) {
            head = 0;
            tail = 0;
            a[tail] = value;
            return true;
        }
        if (isFull()) {
            return false;
        }
        tail = (tail + 1) % size;
        a[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % size;
        }
        return true;

    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return a[head];
        }
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return a[tail];
        }

    }

    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }

    public boolean isFull() {
        return head - tail == 1 || tail - head == size - 1;

    }

    /**
     * https://leetcode-cn.com/leetbook/read/queue-stack/kzlb5/
     *
     * @return
     */
    public boolean isFull1() {
        return (tail + 1) % size == head;
    }


    public static void main(String[] args) {
        MyCircularQueue ma = new MyCircularQueue(3);
        ma.enQueue(1);
        ma.enQueue(1);
        ma.enQueue(1);
    }
}
