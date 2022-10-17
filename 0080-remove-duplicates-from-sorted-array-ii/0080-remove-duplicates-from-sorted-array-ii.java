class Solution {
    public int removeDuplicates(int[] nums) {
        int store = 0;
        int count = 0;
        int prev = nums[0] - 1;
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            if (prev != n) {
                prev = n;
                count = 0;
            }
            if (count < 2) {
                swap(nums, i, store);
                store++;
            }
            count++;
        }
        return store;
    }
    
    private void swap(int[] nums, int a, int b) {
        int aTmp = nums[a];
        nums[a] = nums[b];
        nums[b] = aTmp;
    }
}