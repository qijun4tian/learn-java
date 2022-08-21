package 栈;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:qijun
 * @Description https://leetcode-cn.com/leetbook/read/queue-stack/genw3/
 * @Date 19:19 2022/1/10
 */
public class 每日温度 {

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && temperatures[stack.peekFirst()] <= temperatures[i]) {
                stack.pop();
            }
            list.add(stack.isEmpty() ? 0 : stack.peekFirst() - i);
            stack.push(i);
        }
        int[] a = new int[list.size()];

        for (int i = list.size() - 1; i >= 0; i--) {
            a[list.size() - 1 - i] = list.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        int a[] = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        dailyTemperatures(a);
    }
}
