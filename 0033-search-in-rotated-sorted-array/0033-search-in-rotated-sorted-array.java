class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums);
        int a = 0;
        int b = n - 1;
        while (a < b) {
            int middle = a + (b - a) / 2;
            int value = nums[(middle + pivot) % n];
            if (value < target) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        if (nums[(a + pivot) % n] == target) {
            return (a + pivot) % n;
        } else {
            return -1;
        }
    }
    
    private int findPivot(int[] nums) {
        int a = 0;
        int b = nums.length - 1;
        while (a < b) {
            int middle = a + (b - a) / 2;
            int value = nums[middle];
            if (nums[0] <= value) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        if (nums[a] < nums[0]) {
            return a;
        } else {
            return 0;
        }
    }
}
