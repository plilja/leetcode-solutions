class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = nums.length - 1; i >= 0; --i) {
            int n = nums[i];
            if (n > target) {
                continue;
            }
            dp[i][n] = true;
            for (int j = 0; j <= target; ++j) {
                if (dp[i + 1][j] && j + n <= target) {
                    dp[i][j + n] = true;
                }
                if (dp[i + 1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][target];
    }
}
