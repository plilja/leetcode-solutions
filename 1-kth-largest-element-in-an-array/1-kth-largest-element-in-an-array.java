class Solution {
    public int findKthLargest(int[] nums, int k) {
        int r = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int pivotPosition = left;
            int newPivotPosition = partitionPivot(nums, pivotPosition, left, right);
            if (newPivotPosition == r) {
                return nums[newPivotPosition];
            }
            if (newPivotPosition > r) {
                right = newPivotPosition - 1;
            } else {
                left = newPivotPosition + 1;
            }
        }
        return nums[left];
    }
    
    private int partitionPivot(int[] nums, int pivotPosition, int left, int right) {
        int pivot = nums[pivotPosition];
        swap(nums, pivotPosition, right);
        int store = left;
        for (int i = left; i < right; ++i) {
            int n = nums[i];
            if (n < pivot) {
                swap(nums, i, store);
                store++;
            }
        }
        swap(nums, right, store);
        return store;
    }
    
    private void swap(int[] nums, int a, int b) {
        int aTmp = nums[a];
        nums[a] = nums[b];
        nums[b] = aTmp;
    }
}
