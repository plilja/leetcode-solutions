class Solution {
    public int maxProfit(int k, int[] prices) {
        // dp[i][j][1] = max profit from day i onwards with max j transactions. And you own the stock on start of day i.
        // dp[i][j][0] = max profit from day i onwards with max j transactions. And you do not own the stock on start of day i.
        int[][][] dp = new int[prices.length][k + 1][2];
        
        for (int j = 0; j <= k; ++j) {
            int price = prices[prices.length - 1];
            dp[prices.length - 1][j][0] = 0;
            dp[prices.length - 1][j][1] = price;
        }
        for (int i = prices.length - 2; i >= 0; --i) {
            int price = prices[i];
            dp[i][0][0] = dp[i + 1][0][0];
            dp[i][0][1] = Math.max(dp[i + 1][0][1], dp[i + 1][0][0] + price);
            for (int j = 1; j <= k; ++j) {
                dp[i][j][1] = Math.max(dp[i + 1][j][1], dp[i + 1][j][0] + price);
                dp[i][j][0] = Math.max(dp[i + 1][j][0], dp[i + 1][j - 1][1] - price);
            }
        }
        return dp[0][k][0];
    }
}