class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = prices.length - 1; i >= 0; --i) {
            int price = prices[i];
            if (i + 1 < prices.length) {
                dp[i][0] = Math.max(dp[i + 1][0], dp[i + 1][1] - price);
                dp[i][1] = Math.max(dp[i + 1][1], dp[Math.min(i + 2, prices.length - 1)][0] + price);
            } else {
                dp[i][0] = 0;
                dp[i][1] = price;
            }
        }
        return dp[0][0];
    }
}