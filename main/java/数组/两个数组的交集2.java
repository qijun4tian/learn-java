package 数组;

import tree.ValidateBST;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 * @Author:qijun
 * @Description
 * @Date 14:22 2021/11/21
 */
public class 两个数组的交集2 {
    /**
     * [1,2,2,1]
     * [2]
     */

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int i : nums1) {
            for (int i1 : nums2) {
                if(i == i1){
                    if(countMap.containsKey(i)){
                        countMap.put(i, countMap.get(i) + 1);

                    }else {
                        countMap.put(i,1);
                    }
                }
            }
        }
        int length = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            Integer key = entry.getKey();
            int count1 = 0;
            for (int i : nums1) {
                if(key == i){
                    count1++;
                }
            }
            int count2 = 0;
            for(int j : nums2){
                if(key == j){
                    count2++;
                }
            }
            length = length + Math.min(count1,count2);
            entry.setValue(Math.min(count1, count2));
        }
        int[] result = new int[length];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            for(int j =0; j < entry.getValue(); j++,i++){
                   result[i] = entry.getKey();
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int []nums1 = {1,2,2,1};
        int []nums2 = {2};
        intersect(nums1,nums2);
    }
}
