class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % k != 0) {
            return false;
        }
        boolean[] used = new boolean[nums.length];
        return solve(nums, used, nums.length - 1, 0, sum / k, k);
    }
    
    private boolean solve(int[] nums, boolean[] used, int i, int current, int target, int k) {
        if (k == 0) {
            return true;
        }
        if (current == target) {
            return solve(nums, used, nums.length - 1, 0, target, k - 1);
        }
        for (int j = 0; j <= i; ++j) {
            int v = nums[j];
            if (!used[j] && current + v <= target) {
                used[j] = true;
                if (solve(nums, used, j - 1, current + v, target, k)) {
                    return true;
                }
                used[j] = false;
            }
        }
        return false;
    }
}