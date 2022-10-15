class Solution {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length + 1][3];
        dp[costs.length][0] = 0;
        dp[costs.length][1] = 0;
        dp[costs.length][2] = 0;
        for (int i = costs.length - 1; i >= 0; --i) {
            int[] cost = costs[i];
            dp[i][0] = cost[0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = cost[1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = cost[2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
        }
        return Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);
    }
}