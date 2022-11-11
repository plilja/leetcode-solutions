class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
        }
        return dfs(source, graph, destination, new HashMap<>());
    }
    
    private boolean dfs(int m, Map<Integer, List<Integer>> graph, int dest, Map<Integer, Boolean> vis) {
        if (m == dest) {
            return graph.getOrDefault(m, List.of()).isEmpty();
        }
        if (vis.containsKey(m)) {
            return vis.get(m);
        }
        vis.put(m, false);
        var neighbours = graph.getOrDefault(m, List.of());
        if (neighbours.isEmpty()) {
            return false;
        }
        boolean result = true;
        for (int nei : neighbours) {
            result = result && dfs(nei, graph, dest, vis);
        }
        vis.put(m, result);
        return result;
    }
}