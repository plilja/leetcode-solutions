class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 1; i < nums.length; ++i) {
            int diff = nums[i] - nums[0];
            result += diff;
        }
        return result;
    }
}