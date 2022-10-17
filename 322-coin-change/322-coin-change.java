class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1]; // dp[i][j] = min coins to make value j using coins between idx 0 and i
        for (int i = 0; i <= coins.length; ++i) {
            for (int j = 1; j <= amount; ++j) {
                dp[i][j] = Integer.MAX_VALUE - 1;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= coins.length; ++i) {
            int coin = coins[i - 1];
            for (int j = 1; j <= amount; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coin) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coin] + 1);
                }
            }
        }
        int coinsNeeded = dp[coins.length][amount];
        if (coinsNeeded == Integer.MAX_VALUE - 1) {
            return -1;
        } else {
            return coinsNeeded;
        }
    }
}
