class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            counts.merge(n, 1, (a, b) -> a + b);
        }
        int result = 0;
        for (var entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                result += entry.getKey();
            }
        }
        return result;
    }
}