class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int m = 2; m <= n; ++m) {
            for (int i = 1; i <= m; ++i) {
                int left = dp[i - 1];
                int right = dp[m - i];
                dp[m] += left * right;
            }
        }
        return dp[n];
    }
}