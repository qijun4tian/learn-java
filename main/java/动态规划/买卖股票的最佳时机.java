package 动态规划;

/**
 * @Author:qijun
 * @Description
 * @Date 20:12 2021/11/28
 */
public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {

            for (int j = i + 1; j < prices.length; j++) {
                if(prices[j] > prices[i]){
                    max = Math.max(prices[j] - prices[i],max);
                }
            }
        }
        return max;

    }
}
