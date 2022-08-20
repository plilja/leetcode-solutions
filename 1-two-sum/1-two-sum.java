class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToLastIndex = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            numToLastIndex.put(n, i);
        }
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            int rem = target - n;
            int lastIndex = numToLastIndex.getOrDefault(rem, -1);
            if (lastIndex != -1) {
                if (rem == n) {
                    if (i != lastIndex) {
                        return new int[]{i, lastIndex};
                    }
                } else {
                    return new int[]{i, lastIndex};
                }
            }
        }
        return new int[]{-1, -1}; // No solution found
    }
}
