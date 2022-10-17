class Solution {
    public int searchInsert(int[] nums, int target) {
        int a = 0;
        int b = nums.length;
        while (a < b) {
            int middle = a + (b - a) / 2;
            if (nums[middle] < target) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        return a;
    }
}
