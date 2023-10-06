package 动态规划;

/**
 * @author qijun
 * @since 2023/10/6
 */
public class 买卖股票含手续费 {

    public static int maxProfit(int[] prices, int fee) {

        int dp[][] = new int[prices.length][2];
        if(prices.length < 2){
            return 0;
        }
        // 0 代表持有现金 1代表持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        dp[1][0] = Math.max(prices[1] + dp[0][1]  - fee, dp[0][0]);
        dp[1][1] = (dp[0][0] - prices[1]);

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(prices[i] + dp[i-1][1]  - fee, dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
        }
        return dp[prices.length -1][0];

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
