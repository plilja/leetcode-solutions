class Solution {
    public int missingNumber(int[] nums) {
        int inZeroPosition = -1;
        boolean lastFound = false;
        for (int i = 0; i < nums.length; ++i) {
            int m = Math.abs(nums[i]);
            if (m == nums.length) {
                lastFound = true;
            } else {
                if (nums[m] == 0) {
                    inZeroPosition = m;
                } else {
                    nums[m] *= -1;
                }
            }
        }
        if (!lastFound) {
            return nums.length;
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] >= 0 && inZeroPosition != i) {
                    return i;
                }
            }
        }
        throw new IllegalStateException("no solution found");
    }
}
