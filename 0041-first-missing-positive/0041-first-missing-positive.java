class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int minPositive = Integer.MAX_VALUE;
        while (i < nums.length) {
            int val = nums[i];
            if (val > 0) {
                minPositive = Math.min(minPositive, val);
            }
            if (val >= 1 && val - 1 < nums.length && val - 1 != i && nums[val - 1] != val) {
                swap(nums, val - 1, i);
            } else {
                i++;
            }
        }
        if (minPositive > 1) {
            return 1;
        }
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int iTmp = nums[i];
        nums[i] = nums[j];
        nums[j] = iTmp;
    }
}
