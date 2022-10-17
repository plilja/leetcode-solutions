class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0, dp.length, nums.length + 1);
        dp[0] = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (dp[i] > nums.length) {
                break;
            }
            int n = nums[i];
            for (int j = 1; j <= n && i + j < nums.length; ++j) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);  
            }
        }
        return dp[nums.length - 1];
    }
}
