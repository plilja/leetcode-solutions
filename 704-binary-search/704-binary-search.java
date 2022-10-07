class Solution {
    public int search(int[] nums, int target) {
        int a = 0;
        int b = nums.length - 1;
        while (a < b) {
            int middle = (a + b) / 2;
            int value = nums[middle];
            if (value < target) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        if (nums[a] == target) {
            return a;
        } else {
            return -1;
        }
    }
}
