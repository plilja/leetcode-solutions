class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int result = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> sumToCount = new TreeMap<>();
        int[] bestSumAt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (i - k - 1 >= 0) {
                int sum = bestSumAt[i - k - 1];
                int count = sumToCount.merge(sum, -1, Integer::sum);
                if (count == 0) {
                    sumToCount.remove(sum);
                }
            }
            int bestInRange;
            if (sumToCount.isEmpty() || sumToCount.lastKey() < 0) {
                bestInRange = 0;
            } else {
                bestInRange = sumToCount.lastKey();
            }
            sumToCount.merge(bestInRange + n, 1, Integer::sum);
            bestSumAt[i] = bestInRange + n;
            result = Math.max(result, bestInRange + n);
        }
        return result;
    }
}
