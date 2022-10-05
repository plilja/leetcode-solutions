class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int result = 0;
        int left = -1;
        TreeMap<Integer, Integer> numToCount = new TreeMap<>();
        for (int right = 0; right < nums.length; ++right) {
            numToCount.merge(nums[right], 1, (a, b) -> a + b);
            while (numToCount.lastKey() - numToCount.firstKey() > limit) {
                left++;
                int newCount = numToCount.merge(nums[left], -1, (a, b) -> a + b);
                if (newCount == 0) {
                    numToCount.remove(nums[left]);
                }
            }
            result = Math.max(result, right - left);
        }
        return result;
    }
}