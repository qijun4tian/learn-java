package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qijun
 * @Description
 * @Date 9:18 2022/7/9
 */
public class LenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> map = new HashMap();
        for(int i =0;i <arr.length; i++){
            map.put(arr[i],i);

        }
        int max = 0;
        for(int i =0; i < arr.length - 1; i++){
            for(int j = i + 1;  j < arr.length; j++){
                if(arr.length -1 - j <= max){
                    break;
                }
                int temp1 = arr[i];
                int temp2 = arr[j];
                int tempMax = 0;
                while(map.containsKey(temp1 + temp2)){
                    tempMax++;
                    int preTemp2 = temp2;
                    temp2 = temp1 + temp2;
                    temp1 = preTemp2;


                }
                // System.out.println("tempMax=" + tempMax);

                max = Math.max(tempMax,max);

            }
        }
        return max == 0 ? max : max + 2;

    }

    public static void main(String[] args) {
        LenLongestFibSubseq lenLongestFibSubseq = new LenLongestFibSubseq();
        System.out.println(lenLongestFibSubseq.lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
    }
}
