class Solution {
    public int triangularSum(int[] nums) {
        for (int j = nums.length - 1; j >= 1; j--) {
            for (int i = 0; i < j; ++i) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }
}
