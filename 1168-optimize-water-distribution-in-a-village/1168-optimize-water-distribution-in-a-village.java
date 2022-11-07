class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] pipe: pipes) {
            int house1 = pipe[0] - 1;
            int house2 = pipe[1] - 1;
            int cost = pipe[2];
            graph.computeIfAbsent(house1, k -> new HashMap<>()).merge(house2, cost, (a, b) -> Math.min(a, b));
            graph.computeIfAbsent(house2, k -> new HashMap<>()).merge(house1, cost, (a, b) -> Math.min(a, b));
        }
        PriorityQueue<WellOrPipe> pq = new PriorityQueue<>((a, b) -> {
            return a.cost - b.cost;
        });
        for (int i = 0; i < n; ++i) {
            pq.add(new WellOrPipe(i, wells[i]));
        }
        int result = 0;
        boolean[] visited = new boolean[n];
        while (!pq.isEmpty()) {
            WellOrPipe wp = pq.poll();
            if (visited[wp.house]) {
                continue;
            }
            visited[wp.house] = true;
            result += wp.cost;
            for (var entry : graph.getOrDefault(wp.house, Map.of()).entrySet()) {
                if (!visited[entry.getKey()]) {
                    pq.add(new WellOrPipe(entry.getKey(), entry.getValue()));
                }
            }
            
        }
        return result;
    }
    
    private record WellOrPipe(int house, int cost) {
    }
}