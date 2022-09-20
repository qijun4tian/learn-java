package 其他;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author qijun
 * @Description
 * @Date 22:39 2022/7/1
 */
public class Cal {
    Set<Integer> set = new HashSet();
    public List<Integer> diffWaysToCompute(String expression) {
        int size = expression.length();
        List<String> list = new ArrayList();
        int begin = 0;
        for(int i =0 ; i< expression.length(); i++){

            if(expression.charAt(i) == '*'
                    || expression.charAt(i) == '-'
                    || expression.charAt(i) == '+'){
                list.add(expression.substring(begin,i));
                list.add(expression.substring(i,i+1));
                begin = i + 1;

            }
        }
        list.add(expression.substring(begin));
        getResult(list);
        return new ArrayList(set);


    }

    public void getResult(List<String> list){
        if(list.size() == 3){
            int a = Integer.parseInt(list.get(0));
            int b = Integer.parseInt(list.get(2));
            int result = 0;
            if(list.get(1).equals("-")){

                result = a - b;
            }else if(list.get(1).equals("+")){
                result = a + b;
            }else{
                result = a * b;
            }
            set.add(result);
            return;

        }
        int begin  = 0;
        int end = 2;
        while(end < list.size()){
            int a = Integer.parseInt(list.get(begin));
            int b = Integer.parseInt(list.get(end));
            int result = 0;
            if(list.get(begin+1).equals("-")){

                result = a - b;
            }else if(list.get(begin+1).equals("+")){
                result = a + b;
            }else{
                result = a * b;
            }
            List<String> tempList = new ArrayList();
            tempList.addAll(list.subList(0,begin));
            tempList.add(String.valueOf(result));
            tempList.addAll(list.subList(end + 1, list.size()));
            getResult(tempList);
            begin = begin + 2;
            end = end + 2;
        }

    }

    public static void main(String[] args) {
        Cal cal = new Cal();
        List<Integer> list = cal.diffWaysToCompute("2*3-4*5");
    }
}
