class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= n; ++j) {
                dp[i][j] = -1;
            }
        }
        return rangeCost(1, n, dp);
    }
    
    private int rangeCost(int min, int max, int[][] dp) {
        if (max == min) {
            return 0;
        }
        if (dp[min][max] != -1) {
            return dp[min][max];
        }
        int result = Integer.MAX_VALUE;
        for (int i = min; i <= max; ++i) {
            int costLeft = i;
            if (i > min) {
                costLeft += rangeCost(min, i - 1, dp);
            }
            int costRight = i;
            if (i < max) {
                costRight += rangeCost(i + 1, max, dp);
            }
            result = Math.min(result, Math.max(costLeft, costRight));
        }
        dp[min][max] = result;
        return result;
    }
}