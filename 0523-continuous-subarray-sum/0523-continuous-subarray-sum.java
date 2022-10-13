class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1); // empty subarray
        int acc = 0;
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            acc = (acc + n) % k;
            if (i - seen.getOrDefault(acc, i) >= 2) {
                return true;
            }
            seen.merge(acc, i, (a, b) -> Math.min(a, b));
        }
        return false;
    }
}