class Solution {
    private record QueueItem(int node, int time) implements Comparable<QueueItem> {
        @Override
        public int compareTo(QueueItem other) {
            if (time != other.time) {
                return time - other.time;
            } else {
                return node - other.node;
            }
        }
    }
    
    private record Edge(int node, int time) {}
    
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.computeIfAbsent(u, h -> new ArrayList<>()).add(new Edge(v, w));
        }
        PriorityQueue<QueueItem> q = new PriorityQueue<>();
        q.add(new QueueItem(k, 0));
        Map<Integer, Integer> dist = new HashMap<>();
        int result = 0;
        while (!q.isEmpty()) {
            var item = q.poll();
            if (dist.containsKey(item.node())) {
                continue;
            }
            dist.put(item.node(), item.time());
            result = Math.max(result, item.time());
            for (var edge : graph.getOrDefault(item.node(), List.of())) {
                q.add(new QueueItem(edge.node(), item.time() + edge.time()));
            }
        }
        if (dist.size() == n) {
            return result;
        } else {
            return -1;
        }
    }
}
