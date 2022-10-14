class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cut = new HashMap<>();
        for (var row : wall) {
            int acc = 0;
            for (int i = 0; i < row.size() - 1; ++i) {
                int brick = row.get(i);
                acc += brick;
                cut.merge(acc, 1, (a, b) -> a + b);
            }
        }
        int n = wall.size();
        int best = n;
        for (int v : cut.values()) {
            best = Math.min(best, n - v);
        }
        return best;
    }
}