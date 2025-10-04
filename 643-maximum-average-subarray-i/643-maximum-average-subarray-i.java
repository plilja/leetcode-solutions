class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = -1e16;
        double acc = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - k >= 0) {
                acc -= nums[i - k];
            }
            acc += nums[i];
            if (i >= k - 1) {
                result = Math.max(result, acc / k);
            }
        }
        return result;
    }
}

