package java.栈;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {
    /*使用队列模拟栈，循环出队列，同时把出队的元素加入队尾，最后一个元素直接出队
    * 则是栈的pop,只是返回值则是top
    *
    */

    private Deque<Integer> d1;

    public MyStack() {
        d1 = new LinkedList<>();
    }

    public void push(int x) {
        d1.add(x);
    }

    public int pop() {
        if(empty()){
            return 0;
        }
        int size = d1.size();
        for (int i = 0; i < size; i++) {
            if(i == size -1){
                return d1.poll();
            }else {
                d1.add(d1.poll());
            }
        }
        return 0;
    }

    public int top() {
        if(empty()){
            return 0;
        }
        int size = d1.size();
        for (int i = 0; i < size; i++) {
            Integer poll = d1.poll();
            d1.add(poll);
            if(i == size -1){
                return poll;
            }
        }
        return 0;

    }

    public boolean empty() {
        return d1.size() == 0;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        int top = myStack.top();
    }
}
