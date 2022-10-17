class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int store = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
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
