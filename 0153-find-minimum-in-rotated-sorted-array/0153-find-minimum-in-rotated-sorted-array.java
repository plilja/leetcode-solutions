class Solution {
    public int findMin(int[] nums) {
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
            return nums[a];
        } else {
            return nums[0];
        }
    }
}
