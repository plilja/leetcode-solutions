class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.merge(n, 1, (a, b) -> a + b);
        }
        var sortedCounts = count.entrySet().stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .toList();
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < k; ++j) {
            var entry = sortedCounts.get(j);
            result.add(entry.getKey());
        }
        return listToArray(result);
    }
    
    private int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            result[i] = list.get(i);
        }
        return result;
    }
}
