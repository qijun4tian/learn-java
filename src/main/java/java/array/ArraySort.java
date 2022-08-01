package java.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qijun
 * @date 2022/7/28 8:50
 */
public class ArraySort {
    public static int[] arrayRankTransform(int[] arr) {
        int[] result = Arrays.copyOf(arr,arr.length);
        Map<Integer,Integer> map = new HashMap();
        Arrays.sort(arr);

        int count = 1;
        for(int a : arr){
            if(!map.containsKey(a)){
                map.put(a, count++);
            }

        }

        for(int i =0; i<result.length;i++){

            result[i] = map.get(result[i]);

        }
        return result;




    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,5,8,2};
        int[] ints = arrayRankTransform(arr);

    }
}
