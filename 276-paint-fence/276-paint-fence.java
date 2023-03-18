class Solution {
    public int numWays(int n, int k) {
        int[] dp = new int[2];
        // dp[0] == num ways to paint len i ending with 1 consecutive
        // dp[1] == num ways to paint len i ending with 2 consecutive
        dp[0] = k;
        for (int i = 1; i < n; ++i) {
            int dp0 = dp[0];
            int dp1 = dp[1];
            dp[0] = dp0 * (k - 1) + dp1 * (k - 1);
            dp[1] = dp0;
        }
        return dp[0] + dp[1];
    }
}
