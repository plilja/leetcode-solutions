class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (maxReach < i) {
                return false;
            }
            int n = nums[i];
            maxReach = Math.max(maxReach, i + n);
        }
        return true;
    }
}
