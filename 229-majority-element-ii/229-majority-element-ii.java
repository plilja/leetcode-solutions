class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            counts.merge(n, 1, (a, b) -> a + b);
        }
        List<Integer> result = new ArrayList<>();
        for (var entry : counts.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}