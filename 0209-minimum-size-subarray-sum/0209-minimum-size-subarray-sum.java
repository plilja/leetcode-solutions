class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = -1;
        int acc = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            acc += nums[i];
            while (left + 1 < nums.length && acc - nums[left + 1] >= target) {
                left++;
                acc -= nums[left];
            }
            if (acc >= target) {
                result = Math.min(result, i - left);
            }
        }
        if (result != Integer.MAX_VALUE) {
            return result;
        } else {
            return 0;
        }
    }
}