class Solution {
    private static final int SAFE = 1;
    private static final int NOT_SAFE = -1;
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] safe = new int[graph.length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; ++i) {
            if (isSafe(i, graph, safe)) {
                result.add(i);
            }
        }
        return result;
    }
    
    private boolean isSafe(int v, int[][] graph, int[] safe) {
        if (safe[v] == NOT_SAFE) {
            return false;
        } 
        if (safe[v] == SAFE) {
            return true;
        }
        safe[v] = NOT_SAFE;
        boolean result = true;
        for (int neigh : graph[v]) {
            result = result && isSafe(neigh, graph, safe);
        }
        safe[v] = result ? SAFE : NOT_SAFE;
        return result;
    }
}