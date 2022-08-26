class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int n = Math.abs(nums[i]);
            if (nums[n - 1] < 0) {
                return n;
            } else {
                nums[n - 1] *= -1;
            }
        }
        return -1;
    }
}
