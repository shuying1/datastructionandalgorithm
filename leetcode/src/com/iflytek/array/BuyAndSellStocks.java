package com.iflytek.array;

/**
 * @author yings
 * @create 2022-06-08 10:12
 */
public class BuyAndSellStocks {
    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit3(prices);
        System.out.println("profit="+profit);
    }

    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int profit = prices[i + 1] - prices[i];
            if (profit > 0) {
                sum += profit;
            }
        }
        return sum;
    }

    public static int maxProfit2(int[] prices) {
        int length = prices.length;
        if (prices == null && length < 2) {
            return 0;
        }

        int[][] dp = new int[length][2];
        //初始条件
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            //递推公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //最后一天肯定是手里没有股票的时候，利润才会最大，
        //只需要返回dp[length - 1][0]即可
        return dp[length - 1][0];
    }

    //代码优化
    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int length = prices.length;
        //初始条件
        int hold = -prices[0];//持有股票
        int noHold = 0;//没持有股票
        for (int i = 1; i < length; i++) {
            //递推公式转化的
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, noHold - prices[i]);
        }
        //最后一天肯定是手里没有股票的时候利润才会最大，
        //所以这里返回的是noHold
        return noHold;
    }


}
