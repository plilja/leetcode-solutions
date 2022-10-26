class Solution {
    private static final Map<Pair, Integer> PASSES_THROUGH = Map.of(
        // horizontal
        new Pair(1, 3), 2,
        new Pair(4, 6), 5,
        new Pair(7, 9), 8,
        
        // vertical
        new Pair(1, 7), 4,
        new Pair(2, 8), 5,
        new Pair(3, 9), 6,
        
        // 45 degrees
        new Pair(1, 9), 5,
        new Pair(3, 7), 5
    );
    
    public int numberOfPatterns(int m, int n) {
        int result = 0;
        for (int start = 1; start <= 9; ++start) {
            Set<Integer> visited = new HashSet<>();
            visited.add(start);
            result += solve(m, n, visited, start, 1);
        }
        return result;
    }
    
    private int solve(int m, int n, Set<Integer> visited, int current, int size) {
        if (size == n) {
            return 1;
        }
        int result = 0;
        if (size >= m && size <= n) {
            result++;
        }
        for (int next = 1; next <= 9; ++next) {
            if (!visited.contains(next)) {
                Pair p1 = new Pair(current, next);
                if (PASSES_THROUGH.containsKey(p1) && !visited.contains(PASSES_THROUGH.get(p1))) {
                    continue;
                }
                Pair p2 = new Pair(next, current);
                if (PASSES_THROUGH.containsKey(p2) && !visited.contains(PASSES_THROUGH.get(p2))) {
                    continue;
                }
                visited.add(next);
                result += solve(m, n, visited, next, size + 1);
                visited.remove(next);
            }
        }
        return result;
    }
    
    private record Pair(int from, int to) {
    }
}