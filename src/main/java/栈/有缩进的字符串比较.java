package 栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qijun
 * @date 2022/5/24 12:11
 */
public class 有缩进的字符串比较 {
    public static void main(String[] args) {
        String s1 = "aa##c##cccc";
        String s2 = "aa##c#ccccd#";

        System.out.println(isTheSame(s1,s2));




    }


    public static boolean isTheSame(String s, String t){

        Deque<Character> deque1 = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)== '#'){
                if(deque1.size() > 0) {
                    deque1.pop();
                }
            }else {
                deque1.push(s.charAt(i));
            }
        }
        Deque<Character> deque2 = new LinkedList<>();
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i)== '#'){
                if(deque2.size() > 0) {
                    deque2.pop();
                }
            }else {
                deque2.push(t.charAt(i));
            }
        }

        if(deque1.size() != deque2.size()){
            return false;
        }
        int size = deque1.size();
        if(size > 0) {
            for (int i = 0; i < size; i++) {
                if (deque1.size() > 0) {
                    if (!deque1.pop().equals(deque2.pop())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}


