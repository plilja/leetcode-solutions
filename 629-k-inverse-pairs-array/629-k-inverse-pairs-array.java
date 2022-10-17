class Solution {
    private static long MOD = 1000000007;
    
    public int kInversePairs(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] += dp[i - 1][j];
                    dp[i][j] += dp[i][j - 1];
                    if (j >= i) {
                        dp[i][j] -= dp[i - 1][j - i];
                    }
                    dp[i][j] %= MOD;
                }
            }
        }
        return (int) ((dp[n][k] + MOD - (k > 0 ? dp[n][k - 1] : 0)) % MOD);
    }
}
