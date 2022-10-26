package 滑动窗口;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {

    Deque<Integer> queue = new LinkedList();
    int size = 0;
    double total = 0d;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if(queue.size() == 0){
            System.out.println("size=" + queue.size());
            queue.add(val);
            this.total = val;
            return val;

        }else {
            if(queue.size() < this.size){
                System.out.println("size=" + queue.size());
                queue.add(val);
                this.total += val;
                return total / queue.size();
            }else{
                System.out.println("size=" + queue.size());
                System.out.println("total22");
                int first = queue.poll();
                this.total  += (val-first);
                queue.add(val);
                return total/this.size;


            }
        }
    }


    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        movingAverage.next(1);
        movingAverage.next(10);

    }
}
