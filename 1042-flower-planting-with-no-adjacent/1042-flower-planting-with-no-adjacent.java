class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] path : paths) {
            int x = path[0] - 1;
            int y = path[1] - 1;
            graph.computeIfAbsent(x, k -> new HashSet<>()).add(y);
            graph.computeIfAbsent(y, k -> new HashSet<>()).add(x);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            TreeSet<Integer> colors = new TreeSet<>();
            for (int color = 1; color <= 4; ++color) {
                colors.add(color);
            }
            for (int neighbour : graph.getOrDefault(i, Set.of())) {
                colors.remove(result[neighbour]);
            }
            result[i] = colors.first();
        }
        return result;
    }
}