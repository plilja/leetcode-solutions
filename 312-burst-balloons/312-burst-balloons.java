class Solution {
    public int maxCoins(int[] nums) {
        // dp[i][j] == best way to burst all balloons
        // between i and j given than ballon i-1 and j+1
        // have not been burst
        int[][] dp = new int[nums.length][nums.length];
        for (int range = 0; range < nums.length; ++range) {
            for (int i = 0; i < nums.length - range; ++i) {
                int best = 0;
                int prev = i - 1 >= 0 ? nums[i - 1] : 1;
                int next = i + range + 1 < nums.length ? nums[i + range + 1] : 1;
                for (int j = i; j <= i + range; ++j) {
                    int t = prev * nums[j] * next;
                    if (j - 1 >= i) {
                        t += dp[i][j - 1];
                    }
                    if (j + 1 <= i + range) {
                        t += dp[j + 1][i + range];
                    }
                    best = Math.max(best, t);
                }
                dp[i][i + range] = best;
            }
        }
        return dp[0][nums.length - 1];
    }
}