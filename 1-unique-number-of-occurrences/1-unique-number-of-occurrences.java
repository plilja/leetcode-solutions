class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : arr) {
            counts.merge(n, 1, (a, b) -> a + b);
        }
        return counts.values().size() == new HashSet<>(counts.values()).size();
        
    }
}
