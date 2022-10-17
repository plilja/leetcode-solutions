class Solution {
    public int[] searchRange(int[] nums, int target) {
        int idx1 = findIndex(nums, target);
        if (idx1 >= nums.length || nums[idx1] != target) {
            return new int[]{-1, -1};
        }
        int idx2 = findIndex(nums, target + 1);
        return new int[]{idx1, idx2 - 1};
    }
    
    private int findIndex(int[] nums, int target) {
        int a = 0;
        int b = nums.length;
        while (a < b) {
            int middle = (a + b) / 2;
            int value = nums[middle];
            if (value < target) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        return a;
    }
}
