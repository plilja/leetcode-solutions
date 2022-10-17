class Solution {
    public int majorityElement(int[] nums) {
        int mostCommon = -1;
        int mostCommonCount = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            int newCount = counts.merge(n, 1, (a, b) -> a + b);
            if (newCount > mostCommonCount) {
                mostCommon = n;
                mostCommonCount = newCount;
            }
        }
        return mostCommon;
    }
}
