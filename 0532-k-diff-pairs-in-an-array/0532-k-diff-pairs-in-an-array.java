class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            counts.merge(n, 1, (a, b) -> a + b);
        }
        int result = 0;
        for (var entry : counts.entrySet()) {
            int a = entry.getKey();
            int b = a - k;
            if (a == b) {
                if (entry.getValue() > 1) {
                    result++;
                }
            } else {
                result += counts.getOrDefault(b, 0) > 0 ? 1 : 0;
            }
        }
        return result;
    }
}