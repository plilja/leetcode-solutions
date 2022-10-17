class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[cost.length] = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            dp[i] = cost[i] + dp[i + 1];
            if (i + 2 <= cost.length) {
                dp[i] = Math.min(dp[i], cost[i] + dp[i + 2]);
            }
        }
        return Math.min(dp[0], dp[1]);
    }
}
