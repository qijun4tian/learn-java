package array;

public class MyCircularDeque {
    int front = 0;
    int last = 0;
    int[] arr = null;
    int length = 0;

    public MyCircularDeque(int k) {
        arr = new int[k+1];
        length = k + 1;
        System.out.println("k="+k);
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        front = (front - 1 + length)%length;
        arr[front] = value;


        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){

            return false;
        }
        arr[last] = value;
        last = (last + 1)%length;

        return true;


    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1)%length;
        return true;

    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        last = (last - 1 + length)%length;
        return true;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return arr[front];

    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return arr[(last - 1 + length)%length];

    }

    public boolean isEmpty() {
        return front == last;
    }

    public boolean isFull() {
        System.out.println("fonrt="+front + "last=" + last);
        return (last + length- front)%length  == length -1;

    }
}
