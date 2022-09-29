class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, Set<Integer>> busToStops = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            int[] route = routes[i];
            Set<Integer> stops = new HashSet<>();
            for (int stop : route) {
                stops.add(stop);
            }
            busToStops.put(i, stops);
        }
        // Graph consists of busses, source and target
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int source2 = -1;
        int target2 = -2;
        for (int i = 0; i < routes.length; ++i) {
            Set<Integer> stops = busToStops.get(i);
            if (stops.contains(source)) {
                graph.computeIfAbsent(i, k -> new ArrayList<>()).add(source2);
                graph.computeIfAbsent(source2, k -> new ArrayList<>()).add(i);
            }
            if (stops.contains(target)) {
                graph.computeIfAbsent(i, k -> new ArrayList<>()).add(target2);
                graph.computeIfAbsent(target2, k -> new ArrayList<>()).add(i);
            }
            for (int j = i + 1; j < routes.length; ++j) {
                Set<Integer> otherStops = busToStops.get(j);
                boolean intersects = false;
                for (int k : stops) {
                    if (otherStops.contains(k)) {
                        intersects = true;
                        break;
                    }
                }
                if (intersects) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    graph.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                }
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        Deque<Integer> dists = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.add(source2);
        dists.add(-1);
        while (!q.isEmpty()) {
            int bus = q.pollFirst();
            int dist = dists.pollFirst();
            if (visited.contains(bus)) {
                continue;
            }
            visited.add(bus);
            if (bus == target2) {
                return dist;
            }
            for (int neighbour : graph.getOrDefault(bus, List.of())) {
                q.add(neighbour);
                dists.add(dist + 1);
            }
        }
        return -1;
    }
}