package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:qijun
 * @Description
 * @Date 20:45 2021/12/11
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i%15 == 0){
               list.add("FizzBuzz");
            }else if(i%3==0){
                list.add("Fizz");
            }else if(i%5 == 0){
                list.add("Buzz");
            }else {
                list.add(String.valueOf(i));
            }

        }
        return list;
    }
}
