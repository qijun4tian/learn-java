package java.其他;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qijun
 * @date 2021/12/7 20:43
 */
public class 有效的括号 {

    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(aChar == '(' || aChar == '{' || aChar == '['){
                deque.push(aChar);
            }

            if(aChar == ')' && (deque.size() == 0 || deque.pop() != '(')){
                return false;
            }
            if(aChar == '}' && (deque.size() == 0 || deque.pop() != '{')){
                return false;
            }
            if(aChar == ']' && (deque.size() == 0 || deque.pop() != '[')){
                return false;
            }

        }
        return deque.size() == 0;

    }
}
