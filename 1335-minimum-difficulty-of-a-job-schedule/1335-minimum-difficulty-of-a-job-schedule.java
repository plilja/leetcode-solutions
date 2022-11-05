class Solution {
    private static final int BIG = 1000000;
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        int[][] dp = new int[jobDifficulty.length + 1][d + 1];
        for (int i = 0; i < jobDifficulty.length + 1; ++i) {
            Arrays.fill(dp[i], BIG);
        }
        for (int i = jobDifficulty.length - 1; i >= 0; --i) {
            int max = 0;
            for (int j = i; j < jobDifficulty.length; ++j) {
                max = Math.max(max, jobDifficulty[j]);
            }
            dp[i][1] = max;
            for (int k = 2; k <= d; ++k) {
                max = 0;
                for (int j = i; j < jobDifficulty.length; ++j) {
                    max = Math.max(max, jobDifficulty[j]);
                    dp[i][k] = Math.min(dp[i][k], dp[j + 1][k - 1] + max);
                }
            }
        }
        if (dp[0][d] < BIG) {
            return dp[0][d];
        } else {
            return -1;
        }
    }
}