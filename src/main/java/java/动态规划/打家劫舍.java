package java.动态规划;

/**
 * @Author:qijun
 * @Description
 * @Date 21:40 2021/11/30
 */
public class 打家劫舍 {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[2] = dp[0] + nums[2];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int max = Math.max(dp[0],dp[1]);
        for (int i =2; i< nums.length; i++){
            if(i>= 3) {
                dp[i] = Math.max(dp[i - 2],dp[i-3]) + nums[i];
                max = Math.max(max, dp[i]);
            }else {
                dp[i] = dp[i - 2] + nums[i];
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
