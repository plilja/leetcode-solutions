class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int nextOdd = -1;
        int nextEven = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) {
                nextEven = getNextEven(nums, nextEven + 1);
                swap(nums, i, nextEven);
            } else {
                nextOdd = getNextOdd(nums, nextOdd + 1);
                swap(nums, i, nextOdd);
            }
        }
        return nums;
    }
    
    private void swap(int[] nums, int a, int b) {
        int aTmp = nums[a];
        nums[a] = nums[b];
        nums[b] = aTmp;
    }
    
    private int getNextEven(int[] nums, int i) {
        while (i < nums.length && nums[i] % 2 == 1) {
            i++;
        }
        return i;
    }
    
    private int getNextOdd(int[] nums, int i) {
        while (i < nums.length && nums[i] % 2 == 0) {
            i++;
        }
        return i;
    }
}