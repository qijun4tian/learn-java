package 栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class 逆波兰表达式求值 {


    public static int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+") ||
                    token.equals("-") ||
                    token.equals("*") ||
                    token.equals("/")) {
                String pop = stack.pop();
                int i = Integer.parseInt(pop);
                int j = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+":
                        stack.push(String.valueOf(i + j));
                        break;
                    case "-":
                        stack.push(String.valueOf(j - i));
                        break;
                    case "*":
                        stack.push(String.valueOf(i * j));
                        break;
                    default:
                        stack.push(String.valueOf(j / i));
                        break;
                }
            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    
}
