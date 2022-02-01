package 双指针;


import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import java.util.Base64;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class 平方数组 {



    public int[] sortedSquares(int[] nums) {
        int begin = 0;
        int end = nums.length -1;
        int result = 0;
        while (begin <= end){
            int middle = begin + (end -begin)/2;
            result = middle;
            if(nums[middle] == 0){
                break;
            }else if(nums[middle] > 0){
                end = middle -1;
            }else {
                begin = middle + 1;
            }

        }
        result = nums[result] >= 0 ? result : result + 1;
        int[] result1 = new int[nums.length];

        int begin1 = result;
        int begin2 = result-1;
        int k = 0;
        while (begin1 < nums.length  && begin2 >= 0){
            if(nums[begin1] > Math.abs(nums[begin2])){
                result1[k++] = (int)Math.pow(nums[begin2],2);
                begin2--;
            }else {
                result1[k++] = (int)Math.pow(nums[begin1],2);
                begin1++;
            }
        }
        while (begin1 < nums.length){
            result1[k++] = (int)Math.pow(nums[begin1++],2);
        }

        while (begin2 >= 0){
            result1[k++] = (int)Math.pow(nums[begin2--],2);
        }
        return  result1;

    }


}
