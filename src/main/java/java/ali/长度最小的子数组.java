package java.ali;

/**
 * @author qijun
 * @date 2022/4/20 19:39
 */
public class 长度最小的子数组 {


    public int minSubArrayLen(int target, int[] nums) {

        int start = 0;
        int end = 0;
        int length = nums.length;
        int sum = 0;
        while (start < length && end < length ){
            while (sum < target && end < length){
                sum = sum + nums[end++];
            }


        }
        return 0;
    }
}
