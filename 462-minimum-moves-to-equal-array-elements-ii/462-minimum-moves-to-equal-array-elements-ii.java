class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        long sumSmaller = 0;
        long sumLarger = 0;
        for (int n : nums) {
            sumLarger += n;
        }
        long best = Long.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            sumLarger -= n;
            long numLarger = nums.length - i - 1;
            long numSmaller = i;
            long costAdjustSmaller = numSmaller * n - sumSmaller;
            long costAdjustLarger = sumLarger - numLarger * n;
            best = Math.min(best, costAdjustSmaller + costAdjustLarger);
            sumSmaller += n;
        }
        return (int) best;
    }
}
