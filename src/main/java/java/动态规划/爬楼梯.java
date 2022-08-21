package java.动态规划;

/**
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn854d/
 * @Author:qijun
 * @Description
 * @Date 19:23 2021/11/28
 */
public class 爬楼梯 {

    public int climbStairs(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairs1(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
