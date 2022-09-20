package 其他;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 *
 * @author qijun
 * @Description
 * @Date 19:18 2022/6/15
 */
public class SmallestDistancePair {

    public int smallestDistancePair(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                treeMap.compute(Math.abs(nums[j]-nums[i]), (u,v)->{
                    if (v == null){
                        return 1;
                    }else {
                        return v + 1;
                    }
                });
            }
        }
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            i = i + entry.getValue();
            if(i >= k){
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SmallestDistancePair smallestDistancePair = new SmallestDistancePair();
        smallestDistancePair.smallestDistancePair(new int[]{1,6,1},3);
        Map<Integer,Integer> map = new HashMap();

        for (Map.Entry entry : map.entrySet()) {

        }
    }
    //public int[] findFrequentTreeSum(TreeNode root) {
    //    Map<Integer,Integer> map = new HashMap();
    //    List<Integer> list = new ArrayList();
    //    int max = 0;
    //    for(Map.Entry<Integer,Integer> entry : map.entrySet()){
    //        int value = entry.getValue();
    //        if(entry.getValue() == max){
    //            list.add(entry.getKey());
    //        }
    //
    //    }
    //    int[] result = new int[list.size()];
    //    //return list.toArray(result);
    //
    //}
}
