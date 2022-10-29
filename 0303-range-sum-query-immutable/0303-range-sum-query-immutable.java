class NumArray {
    private final int[] prefixSums;

    public NumArray(int[] nums) {
        prefixSums = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0) {
                prefixSums[i] = prefixSums[i - 1] + nums[i];
            } else {
                prefixSums[i] = nums[i];
            }
        }
    }
    
    public int sumRange(int left, int right) {
        int result = prefixSums[right];
        if (left > 0) {
            result -= prefixSums[left - 1];
        }
        return result;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */