class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int n : nums) {
            numToCount.merge(n, 1, (a, b) -> a + b);
        }
        int result = 0;
        for (var entry : numToCount.entrySet()) {
            int count = entry.getValue();
            int numOneSmaller = numToCount.getOrDefault(entry.getKey() - 1, 0);
            if (numOneSmaller > 0) {
                result = Math.max(result, numOneSmaller + count);
            }
            int numOneLarger = numToCount.getOrDefault(entry.getKey() + 1, 0);
            if (numOneLarger > 0) {
                result = Math.max(result, numOneLarger + count);
            }
        }
        return result;
    }
}
