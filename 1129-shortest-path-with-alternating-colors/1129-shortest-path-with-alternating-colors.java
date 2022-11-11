class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> redGraph = buildGraph(redEdges);
        Map<Integer, List<Integer>> blueGraph = buildGraph(blueEdges);
        
        int[] distRed = new int[n];
        int[] distBlue = new int[n];
        Arrays.fill(distRed, -1);
        Arrays.fill(distBlue, -1);
        
        Deque<QElem> q = new ArrayDeque<>();
        q.add(new QElem(0, Color.RED, 0));
        q.add(new QElem(0, Color.BLUE, 0));
        while (!q.isEmpty()) {
            QElem elem = q.poll();
            int[] dists;
            Map<Integer, List<Integer>> graph;
            Color otherColor;
            if (elem.lastColor == Color.RED) {
                dists = distRed;
                graph = blueGraph;
                otherColor = Color.BLUE;
            } else {
                dists = distBlue;
                graph = redGraph;
                otherColor = Color.RED;
            }
            if (dists[elem.node] != -1 && dists[elem.node] <= elem.dist) {
                continue;
            }
            dists[elem.node] = elem.dist;
            for (int neighbour : graph.getOrDefault(elem.node, List.of())) {
                q.add(new QElem(neighbour, otherColor, elem.dist + 1));
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            result[i] = min(distRed[i], distBlue[i]);
        }
        return result;
    }
    
    private int min(int dist1, int dist2) {
        if (dist1 == -1) {
            return dist2;
        } else if (dist2 == -1) {
            return dist1;
        } else {
            return Math.min(dist1, dist2);
        }
    }
    
    private Map<Integer, List<Integer>> buildGraph(int[][] edgeList) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int[] edge : edgeList) {
            int a = edge[0];
            int b = edge[1];
            result.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
        }
        return result;
    }
    
    private record QElem(int node, Color lastColor, int dist) {
    }
    
    private enum Color {
        RED,
        BLUE
    }
}