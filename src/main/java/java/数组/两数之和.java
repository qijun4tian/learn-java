package java.数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:qijun
 * @Description
 * @Date 20:44 2021/11/21
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if(map.containsKey(target-entry.getKey())){
                list.add(entry.getValue().get(0));
                if(map.get(target-entry.getKey()).size() > 1){
                    list.add(map.get(target-entry.getKey()).get(1));
                }else {
                    list.add(map.get(target-entry.getKey()).get(0));
                }
                break;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
       return result;
    }
}
