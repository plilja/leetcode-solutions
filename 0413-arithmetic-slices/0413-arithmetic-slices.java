class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            int diff = nums[i + 1] - nums[i];
            int j = i;
            while (j + 1 < nums.length && nums[j + 1] - nums[j] == diff) {
                j++;
            }
            if (j - i >= 2) {
                result += j - i - 1;
            }
        }
        return result;
    }
}