class Solution {
    public int maxSubArray(int[] nums) {
        int acc = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            if (acc < 0) {
                acc = 0;
            }
            acc += n;
            result = Math.max(result, acc);
        }
        return result;
    }
}
