class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target;
        }
        int n = nums.length;
        int a = 0;
        int b = nums.length;
        int pivot = findPivot(nums);
        while (a < b) {
            int middle = (a + b) / 2;
            int value = nums[(middle + pivot) % n];
            if (value < target) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        return nums[(a + pivot) % n] == target;
    }
    
    private int findPivot(int[] nums) {
        if (nums[0] == nums[nums.length - 1] || nums[0] == nums[1]) {
            for (int i = 0; i < nums.length; ++i) {
                if (i > 0 && nums[i - 1] > nums[i]) {
                    return i;
                }
            }
            return 0;
        }
        int a = 1;
        int b = nums.length;
        while (a < b) {
            int middle = (a + b) / 2;
            int value = nums[middle];
            if (value > nums[0]) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        if (a < nums.length && nums[a] < nums[0]) {
            return a;
        } else {
            return 0;
        }
    }
}
