package 栈;


import java.util.Deque;
import java.util.LinkedList;

public class 字符串解码 {

    public static String decodeString(String s) {

        boolean asBegin = false;
        StringBuilder stringBuilder = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isAlphabetic(s.charAt(i)) && !asBegin){
                stringBuilder.append(s.charAt(i));
            }
            if(s.charAt(i) == '['){
                asBegin = true;
                deque.push(i);
            }
            if(s.charAt(i) == ']'){
                System.out.println("111");
                Integer pop = deque.pop();
                if(deque.size() == 0){
                    asBegin = false;
                    String sub = decodeString(s.substring(pop+1,i));
                    int number = 0;
                    for(int j = pop -1; j>= 0;j--){
                        if(Character.isDigit(s.charAt(j))){
                            number += (s.charAt(j) -'0') * Math.pow(10,pop -1 -j);
                        }else {
                            break;
                        }
                    }
                    System.out.println("number" + number);
                    for (int i1 = 0; i1 < number; i1++) {
                        stringBuilder.append(sub);
                    }
                }
            }

        }
        return stringBuilder.toString();


    }

    public static void main(String[] args) {

        System.out.println(decodeString("3[a2[c]]"));
    }
}
