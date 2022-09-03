class Solution {
    record Edge (int from, int to, int cost) {}
    
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost() - b.cost());
        Set<Integer> visited = new HashSet<>();
        pq.add(new Edge(-1, 0, 0));
        int result = 0;
        while (!pq.isEmpty()) {
            var edge = pq.poll();
            if (visited.contains(edge.to())) {
                continue;
            }
            visited.add(edge.to());
            result += edge.cost();
            for (int j = 0; j < points.length; ++j) {
                if (!visited.contains(j)) {
                    int[] p1 = points[edge.to()];
                    int[] p2 = points[j];
                    int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                    pq.add(new Edge(0, j, dist));
                }
            }
        }
        return result;
    }
}
