package hexiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringTest {


    public static void main(String[] args) {
        String s = "123aaa-45pp167,98";
        int a = 0;
        List<Integer> list = new ArrayList<>();
        while (a < s.length()){
            int begin = -1;
            if(s.charAt(a) == '-' || Character.isDigit(s.charAt(a))){
                begin = a;
                while ((a+1) < s.length() && Character.isDigit(s.charAt(a + 1)) ){
                    a = a+1;
                }
            }

            a++;
            if(begin != -1) {
                String tmp = s.substring(begin, a);
                list.add(Integer.parseInt(tmp));
            }
        }
        Collections.sort(list);
        String result = list.stream().map(e -> e.toString()).collect(Collectors.joining(","));
        System.out.println(result);
    }
}
