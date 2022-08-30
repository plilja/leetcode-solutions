class Solution {
    public long minimumHealth(int[] damage, int armor) {
        // dp[i][0] = min damage from level i to finish when armor is already used 
        // dp[i][1] = min damage from level i to finish when armor is not yet used
        long[][] dp = new long[damage.length + 1][2]; 
        for (int i = damage.length - 1; i >= 0; --i) {
            long d = damage[i];
            dp[i][0] = dp[i + 1][0] + d;
            dp[i][1] = Math.min(dp[i + 1][1] + d, dp[i + 1][0] + Math.max(0, d - armor));
        }
        return dp[0][1] + 1;
    }
}
