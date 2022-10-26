package 其他;

/**
 * @author qijun
 * @date 2022/8/2 21:39
 */
public class MyCircularQueue {
    private int[] array = null;

    private int head;
    private int tail;
    private int n =0;
    public MyCircularQueue(int k) {
        array = new int[k];
        head = -1;
        tail = -1;
        n = k;
    }



    public boolean enQueue(int value) {
        if(isFull()){
            return false;

        }else {
            if(isEmpty()){
                head = 0;
                tail = 0;
            }else{
                tail = (tail  + 1 + n ) %n;
            }
            array[tail] = value;

            return true;

        }

    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }else{
            if(head == tail){
                head = -1;
            }else{
                head = (head + 1 + n)%n;
            }
            return true;

        }



    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }else{
             return array[head];

        }
    }

    public int Rear() {
        System.out.println("tail=" + tail);
        if(isEmpty()){
            return -1;
        }else{
            return  array[tail];

        }
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return head != -1 && (tail - head + n ) %n == n-1;


    }

    public static void main(String[] args) {
        //MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        //myCircularQueue.enQueue(1);
        //myCircularQueue.enQueue(2);
        //myCircularQueue.enQueue(3);
        //System.out.println(myCircularQueue.enQueue(4));
        //int rear = myCircularQueue.Rear();
        //System.out.println("rear" + rear);



        MyCircularQueue myCircularQueue = new MyCircularQueue(1);
        System.out.println(myCircularQueue.enQueue(1)) ;
        myCircularQueue.enQueue(2);
        //myCircularQueue.enQueue(3);
        System.out.println(myCircularQueue.enQueue(4));
        int rear = myCircularQueue.Rear();
        System.out.println("rear" + rear);


    }
}
