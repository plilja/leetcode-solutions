class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, TreeMap<String, Integer>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new TreeMap<>()).merge(to, 1, (a, b) -> a + b);
        }
        List<String> result = new ArrayList<>();
        result.add("JFK");
        dfs("JFK", graph, tickets.size(), result);
        return result;
    }
    
    private boolean dfs(String airport, Map<String, TreeMap<String, Integer>> graph, int rem, List<String> result) {
        if (rem == 0) {
            return true;
        }
        TreeMap<String, Integer> connections = graph.computeIfAbsent(airport, k -> new TreeMap<>());
        for (String connection : new ArrayList<>(connections.keySet())) {
            int newCount = connections.merge(connection, -1, (a, b) -> a + b);
            result.add(connection);
            if (newCount >= 0 && dfs(connection, graph, rem - 1, result)) {
                return true;
            }
            result.remove(result.size() - 1);
            connections.merge(connection, 1, (a, b) -> a + b);
        }
        return false;
    }
}
