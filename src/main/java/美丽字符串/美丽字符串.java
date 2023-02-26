package 美丽字符串;

import com.sun.tracing.dtrace.StabilityLevel;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qijun
 * @version 1.0.0
 */
public class 美丽字符串 {


    public static Integer getCount(Map<Character,Integer> map){
        if(map != null && map.size() > 1) {
            List<Integer> collect = map.values().stream().sorted().collect(Collectors.toList());
            return collect.get(collect.size() - 1) - collect.get(0);
        }else {
            return 0;
        }

    }

    /**
     * 第二种实现
     * @param s
     * @return
     */
    public static Integer getCount(String s){

        int count = 0;
        int[] arr = new int[26];
        for(int i= 0; i< s.length(); i++){
            arr[s.charAt(i) - 'a'] += 1;
            for(int j = i +1; j < s.length(); j++){
                int min = Integer.MAX_VALUE;
                int max = -1;
                arr[s.charAt(j) - 'a'] += 1;

                for (int i1 = 0; i1 < arr.length; i1++) {
                    if(arr[i1] > max){
                        max = arr[i1];
                    }
                    if(arr[i1] < min && arr[i1] !=0){
                        min = arr[i1];
                    }
                }

                if(max != min && min != Integer.MAX_VALUE){
                    System.out.println(s.substring(i,j+1) + "=" + (max -min));
                    count += (max -min);
                }

            }
            Arrays.fill(arr, 0);




        }
        return count;
    }

    public static void main(String[] args) {
        Integer aabcb = getCount("xzvfsppsjfbxdwkqe");
        System.out.println(aabcb);
    }
}
