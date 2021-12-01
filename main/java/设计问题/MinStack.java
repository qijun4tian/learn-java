package 设计问题;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author:qijun
 * @Description
 * @Date 22:04 2021/12/1
 */
public class MinStack {
    private Deque<Integer> stack;
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        Integer min = Integer.MAX_VALUE;
        for (Integer next : stack) {
            min = Math.min(next, min);

        }
        return min;
    }
}
