package 栈;

import java.util.Deque;
import java.util.LinkedList;

public class 逆波兰表达式求值 {


    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for (String token : tokens) {
            if(token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")){
                String pop = stack.pop();
                int i = Integer.parseInt(pop);
                int j = Integer.parseInt(stack.pop());
                if(token.equals("+")){
                    stack.push(String.valueOf(i+j));
                }else if(token.equals("-")){
                    stack.push(String.valueOf(j-i));
                }else if(token.equals("*")){
                    stack.push(String.valueOf(i*j));
                }else {
                    stack.push(String.valueOf(j/i));
                }
            }else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
