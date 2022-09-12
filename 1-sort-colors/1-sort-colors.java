class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
    
    private void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int newPivotIdx = partition(nums, start, end, start);
            quickSort(nums, start, newPivotIdx - 1);
            quickSort(nums, newPivotIdx + 1, end);
        }
    }
    
    private int partition(int[] nums, int start, int end, int pivotIdx) {
        int pivot = nums[pivotIdx];
        int storeIdx = start;
        swap(nums, pivotIdx, end);
        for (int i = start; i < end; ++i) {
            if (nums[i] < pivot) {
                swap(nums, i, storeIdx);
                storeIdx++;
            }
        }
        swap(nums, storeIdx, end);
        return storeIdx;
    }
    
    private void swap(int[] nums, int a, int b) {
        int aTmp = nums[a];
        nums[a] = nums[b];
        nums[b] = aTmp;
    }
}
