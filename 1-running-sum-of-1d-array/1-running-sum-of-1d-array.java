class Solution {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int acc = 0;
        for (int i = 0; i < nums.length; ++i) {
            acc += nums[i];
            result[i] = acc;
        }
        return result;
    }
}
