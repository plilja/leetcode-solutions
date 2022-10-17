class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return allPathsSourceTarget(graph, 0, graph.length - 1, new HashMap<>());
    }
    
    private List<List<Integer>> allPathsSourceTarget(int[][] graph, int source, int target, Map<Integer, List<List<Integer>>> cache) {
        var cached = cache.get(source);
        if (cached != null) {
            return cached;
        }
        List<List<Integer>> result = new ArrayList<>();
        if (source == target) {
            result.add(new ArrayList<>(List.of(target)));
            return result;
        }
        for (int n : graph[source]) {
            List<List<Integer>> paths = allPathsSourceTarget(graph, n, target, cache);
            for (List<Integer> path : paths) {
                List<Integer> copyPath = new ArrayList<>();
                copyPath.add(source);
                copyPath.addAll(path);
                result.add(copyPath);
            }
        }
        cache.put(source, result);
        return result;
    }
}
