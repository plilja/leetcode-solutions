class Solution {
    public int missingElement(int[] nums, int k) {
        int remK = k;
        int start = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] - prev > 1) {
                // there are missing numbers between prev and current num
                int diff = nums[i] - prev - 1;
                if (diff >= remK) {
                    return prev + remK;
                } else {
                    remK -= diff;
                }
            }
            prev = nums[i];
        }
        return prev + remK;
    }
}