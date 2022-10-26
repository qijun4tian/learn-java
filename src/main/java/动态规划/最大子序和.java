package 动态规划;

/**
 * @Author:qijun
 * @Description
 * @Date 21:03 2021/11/30
 */
public class 最大子序和 {
    public static int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i- 1],0) + nums[i];
            max = Math.max(max,dp[i]);
        }
        return max;


    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }
}
