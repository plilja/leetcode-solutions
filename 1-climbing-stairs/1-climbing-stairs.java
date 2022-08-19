class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[2];
        dp[n % 2] = 1;
        for (int i = n - 1; i >= 0; --i) {
            int r = dp[(i + 1) % 2];
            if (i + 2 <= n) {
                r += dp[(i + 2) % 2];
            }
            dp[i % 2] = r;
        }
        return dp[0];
    }
}
