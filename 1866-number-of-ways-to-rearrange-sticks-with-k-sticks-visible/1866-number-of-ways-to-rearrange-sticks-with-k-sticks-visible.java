class Solution {
    private static final int MOD = 1000000007;

    public int rearrangeSticks(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= k; ++i) {
            dp[i][i] = 1;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = (i - 1) * dp[i - 1][j] + dp[i - 1][j - 1];
                dp[i][j] %= MOD;
            }
        }
        return (int) dp[n][k];
    }
}
