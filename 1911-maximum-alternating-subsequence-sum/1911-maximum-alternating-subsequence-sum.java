class Solution {
    public long maxAlternatingSum(int[] nums) {
        // dp[i][0] == best solution with nums from i to end where first elem is even in seq
        // dp[i][0] == best solution with nums from i to end where first elem is odd in seq
        long[][] dp = new long[nums.length + 1][2];
        dp[nums.length][0] = 0;
        dp[nums.length][1] = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            int v = nums[i];
            dp[i][0] = Math.max(dp[i + 1][0], dp[i + 1][1] + v);
            dp[i][1] = Math.max(dp[i + 1][1], dp[i + 1][0] - v);
        }
        return dp[0][0];
    }
}