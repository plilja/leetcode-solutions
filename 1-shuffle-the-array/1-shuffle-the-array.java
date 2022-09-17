class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length / 2; ++i) {
            tmp[2 * i] = nums[i];
        }
        for (int i = 0; i < nums.length / 2; ++i) {
            tmp[2 * i + 1] = nums[n + i];
        }
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = tmp[i];
        }
        return nums;
    }
}
