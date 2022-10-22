class Solution {
    public int minReorder(int n, int[][] connections) {
        var graphs = makeAdjacencyGraph(n, connections);
        var graph = graphs.left();
        var inverseGraph = graphs.right();
        boolean[] visited = new boolean[n];
        int result = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            var neighbours = graph.get(v);
            for (int j : neighbours) {
                if (!visited[j]) {
                    visited[j] = true;
                    result++;
                    q.add(j);
                }
            }
            var inverseNeighbours = inverseGraph.get(v);
            for (int j : inverseNeighbours) {
                if (!visited[j]) {
                    visited[j] = true;
                    q.add(j);
                }
            }
        }
        return result;
    }
    
    private Pair<List<List<Integer>>, List<List<Integer>>> makeAdjacencyGraph(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> inverseGraph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
            inverseGraph.add(new ArrayList<>());
        }
        for (int[] conn : connections) {
            int from = conn[0];
            int to = conn[1];
            graph.get(from).add(to);
            inverseGraph.get(to).add(from);
        }
        return new Pair(graph, inverseGraph);
    }
    
    private record Pair<A, B>(A left, B right) {}
}