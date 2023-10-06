package 动态规划;

/**
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 * @author qijun
 * @since 2023/10/6
 */
public class 买卖股票的最佳时机2 {




    public static int maxProfit(int[] prices) {
        int [] temp = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            temp[i] = -1;
        }

        return maxProfit(prices, 0,prices.length-1,temp);
    }


    public static int maxProfit(int[] prices, int begin, int end ,int[] temp) {
        if(begin >= end){
            return 0;
        }

        if(temp[begin] != -1){
            return temp[begin];
        }

        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = begin; i <= end; i++){
            if(prices[i] < min){
                min = prices[i];
                for(int j = i + 1; j<= end; j++){
                    if(prices[i] < prices[j]){
                        profit = Math.max(prices[j] - prices[i] + maxProfit(prices, j+1, end, temp), profit);
                    }
                }
            }

        }
        temp[begin] = profit;
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
