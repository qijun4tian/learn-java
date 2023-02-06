package 美丽字符串;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qijun
 * @version 1.0.0
 */
public class 美丽字符串 {

    public static void main(String[] args) {
        String s = "aabcbaa";

        Integer count = 0;


        for (int i = 0; i < s.length(); i++) {
            Map<Character,Integer> map = new HashMap<>();
            map.compute(s.charAt(i), (k,v)->{
                if(v == null){
                    return 1;
                }else {
                    return  ++v;
                }
            });
            for (int j = i+1; j < s.length(); j++) {
                map.compute(s.charAt(j), (k,v)->{
                    if(v == null){
                        return 1;
                    }else {
                        return  ++v;
                    }
                });
                count += getCount(map);

            }

        }
        System.out.println(count);
    }
    
    public static Integer getCount(Map<Character,Integer> map){
        if(map != null && map.size() > 1) {
            List<Integer> collect = map.values().stream().sorted().collect(Collectors.toList());
            return collect.get(collect.size() - 1) - collect.get(0);
        }else {
            return 0;
        }

    }
}
