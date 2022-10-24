class Solution {
    private static final int MOD = 1000000007;
    
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int roll = 1; roll <= k; ++roll) {
                for (int h = roll; h <= target; ++h) {
                    dp[i][h] += dp[i - 1][h - roll];
                    dp[i][h] %= MOD;
                }
            }
        }
        return dp[n][target];
    }
}