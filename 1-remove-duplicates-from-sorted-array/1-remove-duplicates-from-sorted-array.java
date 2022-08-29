class Solution {
    public int removeDuplicates(int[] nums) {
        int store = 1;
        int k = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[store - 1]) {
                swap(nums, i, store);
                store++;
                k++;
            }
        }
        return k;
    }
    
    private void swap(int[] nums, int a, int b) {
        int aTmp = nums[a];
        nums[a] = nums[b];
        nums[b] = aTmp;
    }
}
