class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][3][2];
        for (int i = prices.length - 1; i >= 0; --i) {
            int price = prices[i];
            for (int transactions = 1; transactions <= 2; ++transactions) {
                dp[i][transactions][1] = Math.max(
                    dp[i + 1][transactions][1],
                    dp[i + 1][transactions - 1][0] + price
                );
                dp[i][transactions][0] = Math.max(
                    dp[i + 1][transactions][0],
                    dp[i + 1][transactions][1] - price
                );
            }
        }
        return dp[0][2][0];
    }
}