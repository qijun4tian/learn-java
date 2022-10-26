package 字符串;

import 其他.OrderlyQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qijun
 * @date 2022/8/11 19:49
 */
public class Reformat {
    public String reformat(String s) {

        Deque<Character> deque1 = new LinkedList();

        Deque<Character> deque2 = new LinkedList();

        for(int i =0; i< s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                deque1.push(s.charAt(i));
            }else{
                deque2.push(s.charAt(i));

            }

        }

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < s.length()/2; i++){
            if(deque1.size() == 0 || deque2.size() == 0){
                return "";
            }
            if(deque1.size() > deque2.size()) {
                builder.append(deque1.pop());
                builder.append(deque2.pop());
            }else {
                builder.append(deque2.pop());
                builder.append(deque1.pop());
            }
        }
        if(deque1.size() != 0){
            builder.append(deque1.pop());
        }
        if(deque2.size() != 0){
            builder.append(deque2.pop());
        }
        return builder.toString();


    }

    public static void main(String[] args) {
        OrderlyQueue orderlyQueue = new OrderlyQueue();
        //System.out.println(orderlyQueue.reformat("ooo123"));
    }
}
